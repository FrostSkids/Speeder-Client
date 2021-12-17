// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import Benz.hud.ScreenPosition;
import Benz.mods.ModDraggable;

public class ModClearWater extends ModDraggable
{
    @Override
    public int getWidth() {
        return this.font.getStringWidth("");
    }
    
    @Override
    public int getHeight() {
        return this.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        this.font.drawString("", pos.getAbsoluteX() + this.getWidth() + 3, pos.getAbsoluteY() + 4, -1);
        this.mc.gameSettings.ofClearWater = true;
    }
}
