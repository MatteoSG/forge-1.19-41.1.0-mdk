package net.sateenah.pillage.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_PILLAGE = "key.category.pillage.tutorial" ;
    public static final String KEY_DOUBLE_JUMP = "key.pillage.double_jump" ;

    public static final KeyMapping DJUMPING_KEY = new KeyMapping(KEY_DOUBLE_JUMP, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_U, KEY_CATEGORY_PILLAGE);



}
