package com.bluelotuscoding.epicfightclasses.client.renderer.entity;

import com.bluelotuscoding.epicfightclasses.client.renderer.RenderSpellBase;
import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import com.bluelotuscoding.epicfightclasses.world.entity.server.effects.spells.firespells.HinotamaSpellEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class HinotamaRenderer extends RenderSpellBase<HinotamaSpellEntity> {
    public  static final ResourceLocation FIRE_SPELL = new ResourceLocation(EpicFightClassesMain.MOD_ID, "textures/entity/spells/hinotama.png");
    public HinotamaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HinotamaModel());
      //  this.shadowRadius = 0.3F;
    }

    @Override
    public ResourceLocation getTextureLocation(HinotamaSpellEntity entity) {
        return FIRE_SPELL;
    }

}
