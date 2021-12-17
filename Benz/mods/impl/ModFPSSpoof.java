// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import Benz.utils.Render;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import Benz.hud.ScreenPosition;
import java.util.Random;
import Benz.mods.ModDraggable;

public class ModFPSSpoof extends ModDraggable
{
    private Random random;
    private double[] values;
    private boolean isChroma;
    private boolean betterUI;
    
    public ModFPSSpoof() {
        this.isChroma = false;
        this.betterUI = false;
    }
    
    public void FPSSpoofMod() {
        this.random = new Random();
    }
    
    @Override
    public int getWidth() {
        return 46;
    }
    
    @Override
    public int getHeight() {
        return this.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (this.isChroma) {
            Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
            Render.drawChromaString(this.betterUI ? (String.valueOf(Minecraft.getDebugFPS()) + " FPS") : ("FPS: 1" + Minecraft.getDebugFPS()), pos.getAbsoluteX(), pos.getAbsoluteY(), false);
        }
        else {
            Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
            Render.drawChromaString(this.betterUI ? (String.valueOf(Minecraft.getDebugFPS()) + " FPS") : ("FPS: 1" + Minecraft.getDebugFPS()), pos.getAbsoluteX(), pos.getAbsoluteY(), false);
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
