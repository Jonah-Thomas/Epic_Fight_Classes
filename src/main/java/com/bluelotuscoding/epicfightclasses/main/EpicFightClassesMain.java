package com.bluelotuscoding.epicfightclasses.main;

import com.bluelotuscoding.epicfightclasses.gameasset.EFCAnimations;
import com.bluelotuscoding.epicfightclasses.world.item.EFCItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EpicFightClassesMain.MOD_ID)
public class EpicFightClassesMain
{
    public static final String MOD_ID = "epicfightclasses";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    private static EpicFightClassesMain instance;
    private static EpicFightClassesMain getInstance() {
        return instance;
    }

    public EpicFightClassesMain()
    {

        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::doClientStuff);
        eventBus.addListener(this::doCommonStuff);
        eventBus.addListener(EFCAnimations::registerAnimations);

        EFCItems.ITEMS.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        //CLIENT_INGAME_CONFIG = new EFCConfigurationIngame();
    }

    private void doCommonStuff(final FMLCommonSetupEvent event) {
        //event.enqueueWork(EFCGamerules::registerRules);
    }
}
