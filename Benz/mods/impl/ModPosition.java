// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import Benz.utils.Render;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import Benz.hud.ScreenPosition;
import Benz.mods.ModDraggable;

public class ModPosition extends ModDraggable
{
    private boolean isChroma;
    private boolean betterUI;
    
    public ModPosition() {
        this.isChroma = true;
        this.betterUI = true;
    }
    
    @Override
    public int getWidth() {
        return 60;
    }
    
    @Override
    public int getHeight() {
        return 40;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (this.isChroma) {
            Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
            Render.drawChromaString("X: " + Math.round(Minecraft.getMinecraft().thePlayer.posX * 500.0) / 500L, pos.getAbsoluteX() + 2, pos.getAbsoluteY() + 2, false);
            Render.drawChromaString("Y: " + Math.round(Minecraft.getMinecraft().thePlayer.posY * 500.0) / 500L, pos.getAbsoluteX() + 2, pos.getAbsoluteY() + 12, false);
            Render.drawChromaString("Z: " + Math.round(Minecraft.getMinecraft().thePlayer.posZ * 500.0) / 500L, pos.getAbsoluteX() + 2, pos.getAbsoluteY() + 22, false);
            Render.drawChromaString(new StringBuilder().append(this.mc.thePlayer.getHorizontalFacing()).toString(), pos.getAbsoluteX() + 2, pos.getAbsoluteY() + 32, true);
        }
        else {
            this.font.drawString("X: " + Math.round(Minecraft.getMinecraft().thePlayer.posX * 500.0) / 500L, pos.getAbsoluteX() + 2, pos.getAbsoluteY() + 2, -1);
            this.font.drawString("Y: " + Math.round(Minecraft.getMinecraft().thePlayer.posY * 500.0) / 500L, pos.getAbsoluteX() + 2, pos.getAbsoluteY() + 12, -1);
            this.font.drawString("Z: " + Math.round(Minecraft.getMinecraft().thePlayer.posZ * 500.0) / 500L, pos.getAbsoluteX() + 2, pos.getAbsoluteY() + 22, -1);
        }
    }
    
    public boolean isChroma() {
        return this.isChroma;
    }
    
    public void setChroma(final boolean chroma) {
        this.isChroma = chroma;
    }
    
    public void setBetterUI(final boolean betterUI) {
        this.betterUI = betterUI;
    }
}
