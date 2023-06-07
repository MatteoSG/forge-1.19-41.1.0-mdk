package net.sateenah.pillage.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sateenah.pillage.Pillage;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Pillage.MOD_ID) ;

    public static final RegistryObject<Item> Test = ITEMS.register("test",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.PILLAGE_TAB))) ;

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus) ;
    }
}
