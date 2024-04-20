package com.bluelotuscoding.epicfightclasses.world.entity.server;

import net.minecraft.world.entity.Entity;

public interface ILinkedEntity {
    // the purpose for this is to allow other entities to link to the Entity claas from Minecraft's library
    public void link(Entity entity);
}
