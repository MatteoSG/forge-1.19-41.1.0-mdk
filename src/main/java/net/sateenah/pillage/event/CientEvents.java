package net.sateenah.pillage.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sateenah.pillage.Pillage;
import net.sateenah.pillage.util.KeyBinding;

public class CientEvents {
    @Mod.EventBusSubscriber(modid = Pillage.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(KeyBinding.DJUMPING_KEY.consumeClick()){
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a key !"));
            }
        }
    }
    @Mod.EventBusSubscriber(modid = Pillage.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.DJUMPING_KEY);
        }

    }
}
