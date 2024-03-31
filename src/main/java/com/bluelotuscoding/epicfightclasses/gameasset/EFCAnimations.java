package com.bluelotuscoding.epicfightclasses.gameasset;

import com.bluelotuscoding.epicfightclasses.animation.BasicMultipleAttackAnimation;
import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

@Mod.EventBusSubscriber(modid = EpicFightClassesMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EFCAnimations {
    public static StaticAnimation oath_taker_basic_magic_attack_01;


    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put(EpicFightClassesMain.MOD_ID, EFCAnimations::build);
    }

    private static void build() {
        HumanoidArmature biped = Armatures.BIPED;
        oath_taker_basic_magic_attack_01 = new BasicMultipleAttackAnimation(0.15F, "biped/combat/oath_taker_basic_magic_attack_01", biped,
                new AttackAnimation.Phase(0.0F, 0.15F, 0.19F, 0.2F, 0.2F, biped.toolR, EFCColliders.OATH_TAKER)).addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
    }
    /*

    public static Vec3 getfloor(LivingEntityPatch<?> entitypatch, StaticAnimation self, Vec3f WeaponOffset, Joint joint) {
        OpenMatrix4f transformMatrix = entitypatch.getArmature().getBindedTransformFor(entitypatch.getArmature().getPose(1.0f),joint);
        transformMatrix.translate(WeaponOffset);
        OpenMatrix4f CORRECTION = new OpenMatrix4f().rotate(-(float) Math.toRadians(entitypatch.getOriginal().yRotO + 180F), new Vec3f(0, 1, 0));
        OpenMatrix4f.mul(CORRECTION,transformMatrix,transformMatrix);
        float dpx = transformMatrix.m30 + (float) entitypatch.getOriginal().getX();
        float dpy = transformMatrix.m31 + (float) entitypatch.getOriginal().getY();
        float dpz = transformMatrix.m32 + (float) entitypatch.getOriginal().getZ();
        BlockState block = entitypatch.getOriginal().level.getBlockState(new BlockPos(new Vec3(dpx,dpy,dpz)));
        while ((block.getBlock() instanceof BushBlock || block.isAir()) && !block.is(Blocks.VOID_AIR)) {
            dpy--;
            block = entitypatch.getOriginal().level.getBlockState(new BlockPos(new Vec3(dpx,dpy,dpz)));
        }
        return new Vec3(dpx,dpy,dpz);
    }
}*/
}
