package com.bluelotuscoding.epicfightclasses.skill;

import com.google.common.collect.Lists;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class EFCMultipleAnimationSkill extends WeaponInnateSkill {
    protected final StaticAnimation[] attackAnimations;
    protected final Function<ServerPlayerPatch, Integer> selector;

    public static Skill.Builder createConditionalWeaponInnateBuilder() {
        return (new Skill.Builder()).setCategory(SkillCategories.WEAPON_INNATE).setResource(Resource.WEAPON_INNATE_ENERGY);
    }

    public EFCMultipleAnimationSkill(Skill.Builder<? extends Skill> builder, Function<ServerPlayerPatch, Integer> func, StaticAnimation... animations) {
        super(builder);
        this.properties = Lists.newArrayList();
        this.attackAnimations = animations;
        this.selector = func;
    }

    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map)this.properties.get(0), "Each Strikes:");
        return list;
    }

    public WeaponInnateSkill registerPropertiesToAnimation() {
        StaticAnimation[] var1 = this.attackAnimations;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            StaticAnimation animation = var1[var3];
            AttackAnimation anim = (AttackAnimation)animation;
            AttackAnimation.Phase[] var6 = anim.phases;
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                AttackAnimation.Phase phase = var6[var8];
                phase.addProperties(((Map)this.properties.get(0)).entrySet());
            }
        }

        return this;
    }

    public void executeOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {
        executer.playAnimationSynchronized(this.attackAnimations[this.getAnimationInCondition(executer)], 0.0F);
        super.executeOnServer(executer, args);
    }

    public int getAnimationInCondition(ServerPlayerPatch executer) {
        return (Integer)this.selector.apply(executer);
    }
}
