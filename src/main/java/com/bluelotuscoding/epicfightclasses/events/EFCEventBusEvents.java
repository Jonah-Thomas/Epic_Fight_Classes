package com.bluelotuscoding.epicfightclasses.events;

import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import com.bluelotuscoding.epicfightclasses.world.entity.EFCEntityTypes;
import com.bluelotuscoding.epicfightclasses.world.entity.spells.firespells.HinotamaSpellEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EpicFightClassesMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EFCEventBusEvents {


   /* @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EFCEntityTypes.HINOTAMA.get(), HinotamaSpellEntity.setAttributes());
    } */

}
