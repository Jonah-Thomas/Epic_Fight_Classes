package com.bluelotuscoding.epicfightclasses.world.entity;

import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import com.bluelotuscoding.epicfightclasses.world.entity.server.effects.spells.firespells.HinotamaSpellEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EFCEntityTypes {
    public static final DeferredRegister<EntityType<?>> SPELL_ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, EpicFightClassesMain.MOD_ID);

    public static final RegistryObject<EntityType<HinotamaSpellEntity>> HINOTAMA = SPELL_ENTITIES.register("hinotama",
            () -> EntityType.Builder.of(HinotamaSpellEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .build(new ResourceLocation(EpicFightClassesMain.MOD_ID, "hinotama").toString()));


  public static void register(IEventBus eventBus){

      SPELL_ENTITIES.register(eventBus);
  }
}
