package com.bluelotuscoding.epicfightclasses.gameasset;

import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import com.bluelotuscoding.epicfightclasses.skill.spells.fire.HinotamaBurstSpell;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.damagesource.*;


@Mod.EventBusSubscriber(modid = EpicFightClassesMain.MOD_ID , bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EFCSkills {
    // public static Skill ;

    // Guard --------------------------------------------------------
    // public static Skill BARRIER;
    // public static Skill AURA_BARRIER;

    // Weapon Skill ----------------------------------Caused by: java.lang.NullPointerException: Cannot invoke "yesman.epicfight.skill.weaponinnate.WeaponInnateSkill.newProperty()" because "hinotamaSpell" is null----------------------
    // public static Skill ;
        public static Skill HINOTAMA_BURST;
        public static Skill STAND_BASIC_COMBO_ATTACK;


    // Weapon Passive --------------------------------------------------------
    // public static Skill EGO_WEAPON;


    // Passive --------------------------------------------------------


    public static void registerSkills() {
        // DODGES --------------------------------------------------------

       /* SkillManager.register(DodgeMasterSkill::new, DodgeSkill.createDodgeBuilder().setAnimations(
                        new ResourceLocation(WeaponsOfMinecraft.MODID, "biped/skill/dodgemaster_back"),
                        new ResourceLocation(WeaponsOfMinecraft.MODID, "biped/skill/dodgemaster_back"),
                        new ResourceLocation(WeaponsOfMinecraft.MODID, "biped/skill/dodgemaster_right"),
                        new ResourceLocation(WeaponsOfMinecraft.MODID, "biped/skill/dodgemaster_left")).setCreativeTab(WOMCreativeTabs.ITEMS),
                WeaponsOfMinecraft.MODID,"dodge_master");

        SkillManager.register(ShadowStepSkill::new, DodgeSkill.createDodgeBuilder().setAnimations(
                        new ResourceLocation(WeaponsOfMinecraft.MODID, "biped/skill/shadow_step_forward"),
                        new ResourceLocation(WeaponsOfMinecraft.MODID, "biped/skill/shadow_step_backward")).setCreativeTab(WOMCreativeTabs.ITEMS),
                WeaponsOfMinecraft.MODID,"shadow_step");

        SkillManager.register(ChargeSkill::new, ChargeSkill.createChargeBuilder().setAnimations(
                        new ResourceLocation(WeaponsOfMinecraft.MODID, "biped/skill/bull_charge")).setCreativeTab(WOMCreativeTabs.ITEMS),
                WeaponsOfMinecraft.MODID,"bull_charge"); */ //

        // WEAPON PASSIVE --------------------------------------------------------
        //SkillManager.register(DemonMarkPassiveSkill::new, Skill.createBuilder().setCategory(SkillCategories.WEAPON_PASSIVE).setActivateType(ActivateType.DURATION_INFINITE).setResource(Resource.COOLDOWN),
                //WeaponsOfMinecraft.MODID,"demon_mark_passive");


        // WEAPON SKILL --------------------------------------------------------
        //SkillManager.register(HinotamaBurstSpell::new, WeaponInnateSkill.createWeaponInnateBuilder(), "EpicFightClasses", "hinotama_burst");
        SkillManager.register(HinotamaBurstSpell::new, WeaponInnateSkill.createWeaponInnateBuilder(), "epicfightclasses", "hinotama_burst");

       // SkillManager.register(HinotamaSpell::new, WeaponInnateSkill.createWeaponInnateBuilder(),
          //      EpicFightClassesMain.MOD_ID,"hinotama");



        //  GUARD --------------------------------------------------------
        /*
        SkillManager.register(Barrier::new, Barrier.createCounterAttackBuilder().setCreativeTab(EFCCreativeTabs.ITEMS),
                EpicFightClassesMain.MOD_ID,"barrier");


        SkillManager.register(Aura_Barrier::new, Aura_Barrier.createCounterAttackBuilder().setCreativeTab(EFCCreativeTabs.ITEMS),
                EpicFightClassesMain.MOD_ID,"aura_barrier");

        //  PASSIVE --------------------------------------------------------

        SkillManager.register(Ego_Weapon::new, PassiveSkill.createPassiveBuilder().setCreativeTab(EFCCreativeTabs.ITEMS),
                EpicFightClassesMain.MOD_ID,"ego_weapon");*/


    }

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent onBuild) {
        // DODGES --------------------------------------------------------
        // ENDERSTEP = onBuild.build(WeaponsOfMinecraft.MODID, "ender_step");


        // PASSIVES --------------------------------------------------------
        // TORMENT_PASSIVE = onBuild.build(WeaponsOfMinecraft.MODID, "torment_passive");


        //Weapon Innate Skills --------------------------------------------------------
        WeaponInnateSkill hinotamaBurst = (WeaponInnateSkill)onBuild.build("epicfightclasses", "hinotama_burst");
        hinotamaBurst.newProperty()
                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.5F))
                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(20.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .registerPropertiesToAnimation();
        HINOTAMA_BURST = hinotamaBurst;

    }
}