package com.bluelotuscoding.epicfightclasses.world.entity.spells.firespells;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
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

public class HinotamaSpellEntity extends PathfinderMob implements IAnimatable {

    protected static final AnimationBuilder SPELL_CIRCLE_ANIMATION = new AnimationBuilder().addAnimation("hinotama.animation", true);
    private AnimationFactory factory = new GeckoLibUtil().createFactory(this);
    public HinotamaSpellEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    //Here we set the attributes of the entity make sure to create a new Event in the EventBussEvent class that has entityAttributeEvent
    public static AttributeSupplier setAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.ARMOR_TOUGHNESS, 20000.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100.0D).build();
    }

    // Controls The entity Animations
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "Activation", 0,
                this::spellAnimController));
    }
    protected <E extends HinotamaSpellEntity> PlayState spellAnimController(final AnimationEvent<E> event) {
        event.getController().setAnimation(SPELL_CIRCLE_ANIMATION);
        return PlayState.CONTINUE;
    }
    @Override
    public AnimationFactory getFactory() {

        return this.factory;
    }


    /* @Override
    protected void defineSynchedData() {

    }
    @Override
    public Packet<?> getAddEntityPacket() {
        return null;
    }*/

   /* @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
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



}

