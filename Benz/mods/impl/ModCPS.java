// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import Benz.utils.Render;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Mouse;
import java.util.ArrayList;
import Benz.hud.ScreenPosition;
import java.util.List;
import Benz.mods.ModDraggable;

public class ModCPS extends ModDraggable
{
    private boolean isChroma;
    private boolean betterUI;
    private List<Long> clicks;
    private boolean wasPressed;
    private long lastPressed;
    private ScreenPosition pos;
    
    public ModCPS() {
        this.isChroma = true;
        this.betterUI = false;
        this.clicks = new ArrayList<Long>();
    }
    
    @Override
    public int getWidth() {
        return this.font.getStringWidth("CPS: 00");
    }
    
    @Override
    public int getHeight() {
        return this.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        final boolean pressed = Mouse.isButtonDown(0);
        if (pressed != this.wasPressed) {
            this.lastPressed = System.currentTimeMillis();
            if (this.wasPressed = pressed) {
                this.clicks.add(this.lastPressed);
            }
        }
        Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
        Render.drawChromaString("CPS: " + this.getCPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), true);
    }
    
    private int getCPS() {
        final long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000L < time);
        return this.clicks.size();
    }
}
