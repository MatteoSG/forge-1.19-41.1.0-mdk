package net.sateenah.pillage.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab PILLAGE_TAB = new CreativeModeTab("pillage") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.Test.get());
        }
    };
}
