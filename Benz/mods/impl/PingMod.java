// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import Benz.utils.Render;
import net.minecraft.client.gui.Gui;
import Benz.hud.ScreenPosition;
import net.minecraft.client.Minecraft;
import Benz.mods.ModDraggable;

public class PingMod extends ModDraggable
{
    private boolean isChroma;
    private boolean betterUI;
    
    public PingMod() {
        this.isChroma = true;
        this.betterUI = true;
    }
    
    @Override
    public int getWidth() {
        return this.font.getStringWidth("Ping: " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime());
    }
    
    @Override
    public int getHeight() {
        return this.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (this.isChroma) {
            Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
            Render.drawChromaString("Ping: " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime(), pos.getAbsoluteX() + 1, pos.getAbsoluteY(), true);
        }
        else {
            this.font.drawString("Ping: " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime(), pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
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
