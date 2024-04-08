/*package com.bluelotuscoding.epicfightclasses.skill.spells.fire;

import com.bluelotuscoding.epicfightclasses.gameasset.EFCAnimations;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.EntityState;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;

public class HinotamaSpell extends WeaponInnateSkill {
    protected final StaticAnimation attackAnimation;

    public HinotamaSpell(Builder builder) {
        super(builder);
        this.attackAnimation = EFCAnimations.HINOTAMA;
    }

    @Override
    public void onInitiate(SkillContainer container) {
        if(!container.getExecuter().isLogicalClient()) {
            this.setConsumption(container, 6.0f);
            this.setConsumptionSynchronize((ServerPlayerPatch) container.getExecuter(), 6.0f);
        }
        container.setResource(6.0f);
    }

    @Override
    public void executeOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {
        if (executer.consumeStamina(this.consumption) || executer.getOriginal().isCreative()) {
            executer.playAnimationSynchronized(this.attackAnimation, 0);

            // Spawn the HinotamaSpellEntity
            HinotamaSpellEntity hinotamaSpellEntity = new HinotamaSpellEntity(executer.getOriginal().level, executer.getOriginal());

            // Set the position of the entity to the position the player is aiming at
            Vector3d aim = executer.getOriginal().getLookAngle();
            hinotamaSpellEntity.setPos(executer.getOriginal().getX() + aim.x * 2.0D, executer.getOriginal().getY() + executer.getOriginal().getEyeHeight() + aim.y * 2.0D, executer.getOriginal().getZ() + aim.z * 2.0D);

            // Schedule the entity to be removed after 3 seconds
            hinotamaSpellEntity.setLife(60); // 60 ticks = 3 seconds

            executer.getOriginal().level.addFreshEntity(hinotamaSpellEntity);

            super.executeOnServer(executer, args);
        }
    }

    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, this.properties.get(0), "Each Strike:");

        return list;
    }

    @Override
    public boolean isExecutableState(PlayerPatch<?> executer) {
        executer.updateEntityState();
        EntityState playerState = executer.getEntityState();
        return !(executer.getOriginal().isFallFlying() || executer.currentLivingMotion == LivingMotions.FALL || !playerState.canUseSkill() || !executer.getEntityState().canBasicAttack());
    }

    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        return this;
    }

    @Override
    public void updateContainer(SkillContainer container) {
        if(!container.getExecuter().isLogicalClient()) {
            this.setConsumption(container, 6.0f);
            this.setConsumptionSynchronize((ServerPlayerPatch) container.getExecuter(), 6.0f);
        }
        container.setResource(6.0f);
        container.deactivate();
    }
}
*/