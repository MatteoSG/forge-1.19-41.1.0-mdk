package net.sateenah.pillage.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sateenah.pillage.Pillage;
import net.sateenah.pillage.item.custom.TestAdvancedItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Pillage.MOD_ID) ;
    /**
     * creation d'un item :
     * créer l'item ici
     * le référencer dans le dossier en_us.json dans le répertoire lang
     * ajouter le .json de l'item dans models/items
     * ajouter la texture dans texture/item
     */
    public static final RegistryObject<Item> TEST = ITEMS.register("test",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.PILLAGE_TAB))) ;

    public static final RegistryObject<Item> TEST_ADVANCED = ITEMS.register("test_advanced",
            () -> new TestAdvancedItem(new Item.Properties().tab(ModCreativeModTab.PILLAGE_TAB).stacksTo(1))) ;

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus) ;
    }
}
