package com.bluelotuscoding.epicfightclasses.world.entity.spells.firespells;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ProjectileWeaponItem;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributeSupplier;

public class HinotamaSpellEntity extends ProjectileWeaponItem implements IAnimatable {
    private  AnimationFactory factory = new AnimationFactory(this);
   
   public HinotamaSpellEntity(EntityType<? extends Projectile> entityType) {
       super(entityType, level);
   }

    public AnimationFactory getFactory() {

        return factory;
    }
}
