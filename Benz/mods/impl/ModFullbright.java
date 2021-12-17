// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import net.minecraft.client.Minecraft;
import Benz.hud.ScreenPosition;
import Benz.mods.ModDraggable;

public class ModFullbright extends ModDraggable
{
    private ScreenPosition pos;
    
    @Override
    public int getWidth() {
        return 0;
    }
    
    @Override
    public int getHeight() {
        return 0;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        this.font.drawString("", pos.getAbsoluteX() + this.getWidth() + 3, pos.getAbsoluteY() + 4, -1);
        Minecraft.getMinecraft().gameSettings.gammaSetting = 109.0f;
    }
}
