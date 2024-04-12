package com.bluelotuscoding.epicfightclasses.world.entity.server.effects;

import com.bluelotuscoding.epicfightclasses.world.entity.server.ILinkedEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class SpellnSkillEffect extends Entity implements ILinkedEntity {
    public LivingEntity caster;
    protected boolean hasSyncedCaster = false;
    private static final EntityDataAccessor<Optional<UUID>> CASTER = SynchedEntityData.defineId(SpellnSkillEffect.class, EntityDataSerializers.OPTIONAL_UUID);
    public SpellnSkillEffect(EntityType<? extends SpellnSkillEffect> type, Level worldLoaded) {
        super(type, worldLoaded);
    }
    public SpellnSkillEffect(EntityType<? extends SpellnSkillEffect> type, Level world, LivingEntity caster) {
        super(type, world);
        if (!world.isClientSide && caster != null) {
            this.setCasterID(caster.getUUID());
        }
    }

    public void setCasterID(UUID id) {
        getEntityData().set(CASTER, Optional.of(id));
    }

    public Optional<UUID> getCasterID() {
        return getEntityData().get(CASTER);
    }

    // a Method called from the entity class to recieve the UUID of the playeror caster that casts the spell
    @Override
    protected void defineSynchedData() {
        getEntityData().define(CASTER, Optional.empty());
    }

    //a Method called from the entity class to read any additional information regarding the entity
    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        setCasterID(pCompound.getUUID("caster"));
    }

    //a Method called from the entity class that is called to locate and make sure that the UUID given is attached to the caster that casts the spell.
    //another reason for this importance is that this allows for us to be able to utilize the uuid for other purposes.
    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        if (getCasterID().isPresent()) {
            pCompound.putUUID("caster", getCasterID().get());
        }
    }

    //a method called from the entity class thatused to send a packet object to the client side
    //here we used a networkhook to get the spawn packet for the entity, which allows us to spawn the entity on the client side!
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    //The code checks if a given entity is a LivingEntity and, if so, sets it as the caster of a SpellnSkillEffect entity.
    // After this linking, it sets hasSyncedCaster to true to signify a successful link.
    @Override
    public void link(Entity entity) {
        if (entity instanceof LivingEntity) {
            caster = (LivingEntity) entity;
        }
        hasSyncedCaster = true;
    }

    /*
    public List<LivingEntity> getEntityLivingBaseNearby(double radius) {
        return getEntitiesNearby(LivingEntity.class, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double r) {
        return level.getEntitiesOfClass(entityClass, getBoundingBox().inflate(r, r, r), e -> e != this && distanceTo(e) <= r + e.getBbWidth() / 2f);
    }

    public <T extends Entity> List<T> getEntitiesNearbyCube(Class<T> entityClass, double r) {
        return level.getEntitiesOfClass(entityClass, getBoundingBox().inflate(r, r, r), e -> e != this);
    }

    public boolean raytraceCheckEntity(Entity entity) {
        Vec3 from = this.position();
        int numChecks = 3;
        for (int i = 0; i < numChecks; i++) {
            float increment = entity.getBbHeight() / (numChecks + 1);
            Vec3 to = entity.position().add(0, increment * (i + 1), 0);
            BlockHitResult result = level.clip(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
            if (result.getType() != HitResult.Type.BLOCK) {
                return true;
            }
        }
        return false;
    }*/

}
