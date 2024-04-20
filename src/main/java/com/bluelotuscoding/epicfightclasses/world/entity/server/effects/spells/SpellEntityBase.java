package com.bluelotuscoding.epicfightclasses.world.entity.server.effects.spells;

import com.bluelotuscoding.epicfightclasses.world.entity.server.effects.SpellnSkillEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;

public abstract class SpellEntityBase extends SpellnSkillEffect implements IAnimatable, IAnimationTickable {
    public SpellEntityBase(EntityType<? extends SpellnSkillEffect> type, Level worldLoaded) {
        super(type, worldLoaded);
    }

    public SpellEntityBase(EntityType<? extends SpellnSkillEffect> type, Level world, LivingEntity caster) {
        super(type, world, caster);
    }



}
