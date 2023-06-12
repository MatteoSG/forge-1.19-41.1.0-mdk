package net.sateenah.pillage.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            components.add(Component.literal("Right Click to get random number").withStyle(ChatFormatting.DARK_BLUE)) ;
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.AQUA)) ;
        }


        super.appendHoverText(stack, level, components, flag);
    }

    private void outputRandom(Player player){
        player.sendSystemMessage(Component.literal("your number is " + getRandom()));
    }


    private int getRandom(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }


}
