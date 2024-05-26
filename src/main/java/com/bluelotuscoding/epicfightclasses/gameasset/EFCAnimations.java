package com.bluelotuscoding.epicfightclasses.gameasset;

import com.bluelotuscoding.epicfightclasses.animation.BasicMultipleAttackAnimation;
import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;

@Mod.EventBusSubscriber(modid = EpicFightClassesMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EFCAnimations {
    public static StaticAnimation OATH_TAKER_BASIC_ATTACK_01;
    public static StaticAnimation OATH_TAKER_BASIC_ATTACK_02;
    public  static StaticAnimation OATH_TAKER_BASIC_ATTACK_03;
    public static StaticAnimation HINOTAMA;
    public static StaticAnimation MAGE_IDLE;

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put(EpicFightClassesMain.MOD_ID, EFCAnimations::build);
    }

    private static void build() {
        HumanoidArmature biped = Armatures.BIPED;
        // IDLEs
        MAGE_IDLE = new StaticAnimation(0.1F, true, "biped/living/mage_idle", biped);

        // Basic Attacks
        OATH_TAKER_BASIC_ATTACK_01 = new BasicMultipleAttackAnimation(0.15F, "biped/combat/oath_taker_basic_attack_01", biped,
                new AttackAnimation.Phase(0.0F, 0.15F, 0.19F, 0.2F, 0.2F, biped.toolR, EFCColliders.OATH_TAKER)).addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true);

        OATH_TAKER_BASIC_ATTACK_02 = new BasicMultipleAttackAnimation(0.15F, "biped/combat/oath_taker_basic_attack_02", biped,
                new AttackAnimation.Phase(0.0F, 0.15F, 0.19F, 0.2F, 0.2F, biped.toolR, EFCColliders.OATH_TAKER)).addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true);

        OATH_TAKER_BASIC_ATTACK_03 = new BasicMultipleAttackAnimation(0.15F, "biped/combat/oath_taker_basic_attack_03", biped,
                new AttackAnimation.Phase(0.0F, 0.15F, 0.19F, 0.2F, 0.2F, biped.toolR, EFCColliders.OATH_TAKER)).addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true);
    }


}
