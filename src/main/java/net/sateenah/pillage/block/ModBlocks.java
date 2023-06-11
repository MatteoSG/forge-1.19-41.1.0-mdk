package net.sateenah.pillage.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sateenah.pillage.Pillage;
import net.sateenah.pillage.block.custom.AdvancedBlock;
import net.sateenah.pillage.item.ModCreativeModTab;
import net.sateenah.pillage.item.ModItems;

import java.util.function.Supplier;


/**
 * NE PAS OUBLIER DE CREER UN .JSON DANS LE ASSETS/PILLAGE/BLOCKSTATES, MODELS/BLOCK, MODELS/ITEM ET DONC DANS TEXTURES/BLOCK
 */



public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Pillage.MOD_ID) ;

    /** of(Material.STONE) réfère au type de bloque utilisé, copie le son, le bruit de minage

     */
    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CACTUS)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.PILLAGE_TAB) ;
    public static final RegistryObject<Block> TEST_BLOCK_ADVANCED = registerBlock("test_block_advanced"  ,
            () -> new AdvancedBlock(BlockBehaviour.Properties.of(Material.CACTUS)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.PILLAGE_TAB) ;

    public static final RegistryObject<Block> TEST_BLOCK2 = registerBlock("test_block_deux",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    //UniformInt.of(3,7) = drop entre 3 et 7 bulles d'xp
                    UniformInt.of(3,7)), ModCreativeModTab.PILLAGE_TAB) ;




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name,block) ;
        registerBlockItem(name, toReturn, tab) ;

        return toReturn ;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab))) ;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
