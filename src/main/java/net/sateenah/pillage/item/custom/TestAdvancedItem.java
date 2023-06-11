package net.sateenah.pillage.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TestAdvancedItem extends Item {
    public TestAdvancedItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandom(player);
            player.getCooldowns().addCooldown(this, 20);
        }


        return super.use(level, player, hand);
    }

    private void outputRandom(Player player){
        player.sendSystemMessage(Component.literal("your number is " + getRandom()));
    }


    private int getRandom(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }


}