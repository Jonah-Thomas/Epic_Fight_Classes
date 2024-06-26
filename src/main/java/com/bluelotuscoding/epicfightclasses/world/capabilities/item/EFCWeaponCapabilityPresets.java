package com.bluelotuscoding.epicfightclasses.world.capabilities.item;

import com.bluelotuscoding.epicfightclasses.gameasset.EFCAnimations;
import com.bluelotuscoding.epicfightclasses.gameasset.EFCColliders;
import com.bluelotuscoding.epicfightclasses.gameasset.EFCSkills;
import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = EpicFightClassesMain.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)
public class EFCWeaponCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> OATH_TAKER = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder()
                .category(EFCWeaponCategories.OATHTAKER)
                .styleProvider((playerpatch) -> CapabilityItem.Styles.ONE_HAND)
                .collider(EFCColliders.OATH_TAKER)
                .hitSound(EpicFightSounds.BLUNT_HIT)
                .hitParticle(EpicFightParticles.HIT_BLUNT.get())
                .canBePlacedOffhand(false)
                .newStyleCombo(CapabilityItem.Styles.ONE_HAND, EFCAnimations.OATH_TAKER_BASIC_ATTACK_01, EFCAnimations.OATH_TAKER_BASIC_ATTACK_02, EFCAnimations.OATH_TAKER_BASIC_ATTACK_03, Animations.SWORD_DASH, Animations.SWORD_AIR_SLASH)
                .innateSkill(CapabilityItem.Styles.ONE_HAND,(itemstack) -> EFCSkills.HINOTAMA_BURST)
                .comboCancel((style) -> {
                    return false;
                })
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.IDLE, EFCAnimations.MAGE_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.WALK, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.CHASE, Animations.VINDICATOR_CHASE)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.RUN, Animations.BIPED_RUN)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.BLOCK, Animations.SPEAR_GUARD);
        return builder;
    };


    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put("oath_taker", OATH_TAKER);
    }
}
