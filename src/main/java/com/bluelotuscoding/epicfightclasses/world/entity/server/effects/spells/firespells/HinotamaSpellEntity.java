package com.bluelotuscoding.epicfightclasses.world.entity.server.effects.spells.firespells;

import com.bluelotuscoding.epicfightclasses.world.entity.server.effects.SpellnSkillEffect;
import com.bluelotuscoding.epicfightclasses.world.entity.server.effects.spells.SpellEntityBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.Optional;
import java.util.UUID;

public class HinotamaSpellEntity extends SpellEntityBase {
    private static final EntityDataAccessor<Optional<UUID>> SPELL = SynchedEntityData.defineId(HinotamaSpellEntity.class, EntityDataSerializers.OPTIONAL_UUID);
    protected static final AnimationBuilder SPELL_CIRCLE_ANIMATION = new AnimationBuilder().addAnimation("hinotama.animation", true);
    private AnimationFactory factory = new GeckoLibUtil().createFactory(this);
    public HinotamaSpellEntity(EntityType<? extends HinotamaSpellEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(SPELL, Optional.empty());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
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

    @Override
    public int tickTimer() {
        return tickCount;
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

