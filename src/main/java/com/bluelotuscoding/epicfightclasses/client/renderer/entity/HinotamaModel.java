package com.bluelotuscoding.epicfightclasses.client.renderer.entity;

import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import com.bluelotuscoding.epicfightclasses.world.entity.server.effects.spells.firespells.HinotamaSpellEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HinotamaModel extends AnimatedGeoModel<HinotamaSpellEntity> {

    @Override
    public ResourceLocation getModelLocation(HinotamaSpellEntity object) {
        return new ResourceLocation(EpicFightClassesMain.MOD_ID, "geo/spells/hinotama.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(HinotamaSpellEntity object) {
        return new ResourceLocation(EpicFightClassesMain.MOD_ID, "textures/entity/spells/hinotama.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(HinotamaSpellEntity animatable) {
        return new ResourceLocation(EpicFightClassesMain.MOD_ID, "animations/spells/hinotama.animation.json");
    }

}
