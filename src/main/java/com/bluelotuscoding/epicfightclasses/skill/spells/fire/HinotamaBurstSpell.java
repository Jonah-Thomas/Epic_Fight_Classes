package com.bluelotuscoding.epicfightclasses.skill.spells.fire;


import com.bluelotuscoding.epicfightclasses.gameasset.EFCAnimations;
import net.minecraft.network.FriendlyByteBuf;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
import java.util.UUID;


public class HinotamaBurstSpell extends WeaponInnateSkill {
    private static final UUID EVENT_UUID = UUID.fromString("3461f6fb-ac1d-4d0d-950e-b4cde8a96a25");

    public HinotamaBurstSpell(
            WeaponInnateSkill.Builder builder){
        super(builder);
    }

    public void onInitiate(SkillContainer container) {
        if (!container.getExecuter().isLogicalClient()) {
            this.setConsumption(container, 6.0F);
            this.setConsumptionSynchronize((ServerPlayerPatch)container.getExecuter(), 6.0F);
        }

        container.setResource(6.0F);
    }

    public void executeOnServer(ServerPlayerPatch playerPatch, FriendlyByteBuf args) {

            playerPatch.playAnimationSynchronized(EFCAnimations.HINOTAMA_BURST, 0.0F);
            super.executeOnServer(playerPatch, args);
        }



    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);

        container.getExecuter().getEventListener().removeListener(PlayerEventListener.EventType.DEALT_DAMAGE_EVENT_PRE, EVENT_UUID);
    }


    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        return null;
    }
}