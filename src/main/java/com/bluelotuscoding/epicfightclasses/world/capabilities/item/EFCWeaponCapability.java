package com.bluelotuscoding.epicfightclasses.world.capabilities.item;

import java.util.List;
import java.util.Map;

import com.bluelotuscoding.epicfightclasses.gameasset.EFCSkills;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.network.EpicFightNetworkManager;
import yesman.epicfight.network.server.SPChangeSkill;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public class EFCWeaponCapability extends WeaponCapability{
    protected final Map<Style, List<StaticAnimation>> heavyAutoAttackMotions;

    public EFCWeaponCapability(WeaponCapability.Builder builder, EFCWeaponCapability.Builder efbuilder) {
        super(builder);
        this.heavyAutoAttackMotions = efbuilder.heavyAutoAttackMotionMap;
    }

    @Override
    public void changeWeaponInnateSkill(PlayerPatch<?> playerpatch, ItemStack itemstack) {
        super.changeWeaponInnateSkill(playerpatch, itemstack);
        Skill basicAttack = playerpatch.getSkill(SkillSlots.BASIC_ATTACK).getSkill();
        String skillName = "";
        SPChangeSkill.State state = SPChangeSkill.State.ENABLE;
        SkillContainer basicAttackContainter = playerpatch.getSkill(SkillSlots.BASIC_ATTACK);

        if (basicAttack != null) {
            if (basicAttackContainter.getSkill() != basicAttack) {
                basicAttackContainter.setSkill(EFCSkills.STAND_BASIC_COMBO_ATTACK);
            }

            skillName = basicAttack.toString();
        } else {
            state = SPChangeSkill.State.DISABLE;
        }
        basicAttackContainter.setDisabled(basicAttack == null);
        EpicFightNetworkManager.sendToPlayer(new SPChangeSkill(SkillSlots.BASIC_ATTACK, skillName, state), (ServerPlayer) playerpatch.getOriginal());
    }

    public static EFCWeaponCapability.Builder EFbuilder() {
        return new EFCWeaponCapability.Builder();
    }

    public static class Builder extends WeaponCapability.Builder {
        Map<Style, List<StaticAnimation>> heavyAutoAttackMotionMap;

        public Builder() {
            this.heavyAutoAttackMotionMap = Maps.<Style, List<StaticAnimation>>newHashMap();
        }

        public Builder newHeavyStyleCombo(Style style, StaticAnimation... animation) {
            this.heavyAutoAttackMotionMap.put(style, Lists.newArrayList(animation));
            return this;
        }
    }

}