package com.bluelotuscoding.epicfightclasses.world.item;

import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class EFCCreativeTabs {
    public static final CreativeModeTab ITEMS = new CreativeModeTab(EpicFightClassesMain.MOD_ID + ".items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(EFCItems.OATH_TAKER.get());
        }
    };
}
