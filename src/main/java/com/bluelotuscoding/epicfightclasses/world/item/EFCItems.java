package com.bluelotuscoding.epicfightclasses.world.item;

import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EFCItems {
    public  static  final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicFightClassesMain.MOD_ID);

public static final RegistryObject<Item> OATH_TAKER = ITEMS.register("oath_taker",
        () -> new OathTakerItem(new Item.Properties().tab(EFCCreativeTabs.ITEMS).rarity(Rarity.RARE)));
public static final RegistryObject<Item> AMON = ITEMS.register("amon",
            () -> new AmonItem(new Item.Properties().tab(EFCCreativeTabs.ITEMS).rarity(Rarity.RARE)));

}
