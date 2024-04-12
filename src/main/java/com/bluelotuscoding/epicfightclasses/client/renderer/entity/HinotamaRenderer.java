package com.bluelotuscoding.epicfightclasses.client.renderer.entity;

import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import com.bluelotuscoding.epicfightclasses.world.entity.server.effects.spells.firespells.HinotamaSpellEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HinotamaRenderer extends  GeoEntityRenderer<HinotamaSpellEntity> {
    public HinotamaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HinotamaModel());
      //  this.shadowRadius = 0.3F;
    }

    @Override
    public ResourceLocation getTextureLocation(HinotamaSpellEntity instance) {
        return new ResourceLocation(EpicFightClassesMain.MOD_ID, "textures/entity/spells/hinotama.png");
    }

   /* @Override
    public RenderType getRenderType(HinotamaSpellEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(10.0F, 10.0F, 10.0F);
        return super .getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }*/
}
