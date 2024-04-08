package com.bluelotuscoding.epicfightclasses.main;

import com.bluelotuscoding.epicfightclasses.client.renderer.entity.HinotamaRenderer;
import com.bluelotuscoding.epicfightclasses.gameasset.EFCAnimations;
import com.bluelotuscoding.epicfightclasses.gameasset.EFCSkills;
import com.bluelotuscoding.epicfightclasses.world.entity.block.ModBlockEntities;
import com.bluelotuscoding.epicfightclasses.world.entity.EFCEntityTypes;
import com.bluelotuscoding.epicfightclasses.world.entity.spells.firespells.HinotamaSpellEntity;
import com.bluelotuscoding.epicfightclasses.world.item.EFCItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib3.GeckoLib;

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
        //eventBus.addListener(this::clientSetup);
        eventBus.addListener(EFCAnimations::registerAnimations);

        //These are the registered classes that our mod will be using.
        EFCItems.ITEMS.register(eventBus); // ctrl + click EFCItems to see how I registered the classes.
        ModBlockEntities.register(eventBus);
        EFCEntityTypes.register(eventBus);
        EFCSkills.registerSkills();
        GeckoLib.initialize();
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        //CLIENT_INGAME_CONFIG = new EFCConfigurationIngame();
        EntityRenderers.register(EFCEntityTypes.HINOTAMA.get(), HinotamaRenderer::new);
    }


    /*private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(EFCEntityTypes.HINOTAMA.get(), HinotamaRenderer::new);
    }*/

    private void doCommonStuff(final FMLCommonSetupEvent event) {
        //event.enqueueWork(EFCGamerules::registerRules);
    }
}
