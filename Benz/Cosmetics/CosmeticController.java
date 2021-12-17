// 
// Decompiled by Procyon v0.5.36
// 

package Benz.Cosmetics;

import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticController
{
    public static boolean shouldRenderTopHat(final AbstractClientPlayer player) {
        return true;
    }
    
    public static float[] getTopHatColor(final AbstractClientPlayer player) {
        return new float[] { 1.0f, 0.0f, 0.0f };
    }
}
