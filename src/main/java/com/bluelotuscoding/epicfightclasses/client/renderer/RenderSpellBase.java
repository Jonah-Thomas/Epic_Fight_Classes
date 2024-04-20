package com.bluelotuscoding.epicfightclasses.client.renderer;

import com.bluelotuscoding.epicfightclasses.client.renderer.entity.HinotamaModel;
import com.bluelotuscoding.epicfightclasses.world.entity.server.effects.spells.SpellEntityBase;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.provider.GeoModelProvider;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class RenderSpellBase <T extends SpellEntityBase & IAnimatable> extends EntityRenderer<T> implements IGeoRenderer{
    private MultiBufferSource rtb;

    protected RenderSpellBase(EntityRendererProvider.Context context, HinotamaModel hinotamaModel) {
        super(context);
    }

    @Override
    public void setCurrentRTB(MultiBufferSource rtb) {
        this.rtb = rtb;
    }
    @Override
    public MultiBufferSource getCurrentRTB() {
        return this.rtb;
    }


    @Override
    public GeoModelProvider getGeoModelProvider() {
        return null;
    }

    @Override
    public ResourceLocation getTextureLocation(Object animatable) {
        return null;
    }

    @Override
    public ResourceLocation getTextureLocation(T pEntity) {
        return null;
    }
}
