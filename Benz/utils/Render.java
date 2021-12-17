// 
// Decompiled by Procyon v0.5.36
// 

package Benz.utils;

import java.awt.Color;
import net.minecraft.client.Minecraft;

public class Render
{
    public static void drawChromaString(final String string, final int x, final int y, final boolean b) {
        final Minecraft mc = Minecraft.getMinecraft();
        int xTmp = x;
        char[] charArray;
        for (int length = (charArray = string.toCharArray()).length, j = 0; j < length; ++j) {
            final char textChar = charArray[j];
            final long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
            final int i = Color.HSBtoRGB(l % 2000L / 2000.0f, 0.8f, 0.8f);
            final String tmp = String.valueOf(textChar);
            mc.fontRendererObj.drawString(tmp, xTmp, y, i);
            xTmp += mc.fontRendererObj.getCharWidth(textChar);
        }
    }
    
    public static int getChromaStringWidth(final String string) {
        return getChromaStringWidth(null);
    }
}
