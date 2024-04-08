package com.bluelotuscoding.epicfightclasses.world.entity.spells.firespells;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import software.bernie.geckolib3.util.GeckoLibUtil;

public class HinotamaSpellEntity extends Animal implements IAnimatable {

    protected static final AnimationBuilder SPELL_CIRCLE_ANIMATION = new AnimationBuilder().addAnimation("hinotama.animation", true);
    private AnimationFactory factory = new GeckoLibUtil().createFactory(this);
    public HinotamaSpellEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.0D).build();
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "Activation", 100,
                this::spellAnimController));
    }
    protected <E extends HinotamaSpellEntity> PlayState spellAnimController(final AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(SPELL_CIRCLE_ANIMATION);

            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
    }

    /* Sounds
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.CAT_STRAY_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.DOLPHIN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.DOLPHIN_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }*/


    /* Animations */


    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}

