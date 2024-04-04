package com.bluelotuscoding.epicfightclasses.world.entity.spells;

import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpellEntityTypes {
    public static final DeferredRegister<EntityType<?>> SPELL_ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, EpicFightClassesMain.MOD_ID);


    public static void register(IEventBus eventBus) {
        SPELL_ENTITIES.register(eventBus);
    }
}
