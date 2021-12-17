// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import Benz.utils.Render;
import net.minecraft.client.gui.Gui;
import Benz.hud.ScreenPosition;
import Benz.event.EventTarget;
import Benz.event.impl.ClientTickEvent;
import Benz.mods.ModDraggable;

public class ModWalkText extends ModDraggable
{
    private boolean isChroma;
    private boolean betterUI;
    
    public ModWalkText() {
        this.isChroma = true;
        this.betterUI = true;
    }
    
    @Override
    public int getWidth() {
        return this.font.getStringWidth("[Sprinting (KeyHeld)]");
    }
    
    @Override
    public int getHeight() {
        return this.font.FONT_HEIGHT;
    }
    
    @EventTarget
    public void onTick(final ClientTickEvent e) {
        if (this.mc.gameSettings.keyBindForward.isKeyDown() && !this.mc.thePlayer.isUsingItem() && !this.mc.thePlayer.isSneaking() && !this.mc.thePlayer.isCollidedHorizontally) {
            this.mc.thePlayer.setSprinting(true);
        }
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (this.isChroma) {
            Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
            if (!this.mc.thePlayer.capabilities.isFlying && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding() && this.mc.thePlayer.movementInput.moveForward > 0.1 && !this.mc.gameSettings.keyBindBack.isKeyDown() && !this.mc.gameSettings.keyBindRight.isKeyDown() && !this.mc.gameSettings.keyBindLeft.isKeyDown() && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                Render.drawChromaString("[Walking (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
            }
            if (!this.mc.thePlayer.capabilities.isFlying && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding() && this.mc.gameSettings.keyBindBack.isKeyDown() && !this.mc.gameSettings.keyBindRight.isKeyDown() && !this.mc.gameSettings.keyBindLeft.isKeyDown() && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                Render.drawChromaString("[Walking (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
            }
            if (!this.mc.thePlayer.capabilities.isFlying && this.mc.gameSettings.keyBindRight.isKeyDown() && !this.mc.gameSettings.keyBindLeft.isKeyDown() && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                Render.drawChromaString("[Strafing (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
            }
            if (!this.mc.thePlayer.isRiding() && this.mc.thePlayer.capabilities.isFlying) {
                Render.drawChromaString("[Flying (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
            }
            if (!this.mc.thePlayer.capabilities.isFlying && !this.mc.gameSettings.keyBindRight.isKeyDown() && this.mc.gameSettings.keyBindLeft.isKeyDown() && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                Render.drawChromaString("[Strafing (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
            }
            if (!this.mc.thePlayer.capabilities.isFlying && this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                Render.drawChromaString("[Sprinting (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
            }
            if (!this.mc.thePlayer.capabilities.isFlying && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding() && this.mc.thePlayer.movementInput.moveForward <= 0.1 && !this.mc.gameSettings.keyBindBack.isKeyDown() && !this.mc.gameSettings.keyBindRight.isKeyDown() && !this.mc.gameSettings.keyBindLeft.isKeyDown()) {
                Render.drawChromaString("[Standing (NoKeyHeld)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
            }
            else {
                if (!this.mc.thePlayer.capabilities.isFlying && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding() && this.mc.thePlayer.movementInput.moveForward > 0.1 && !this.mc.gameSettings.keyBindBack.isKeyDown() && !this.mc.gameSettings.keyBindRight.isKeyDown() && !this.mc.gameSettings.keyBindLeft.isKeyDown() && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                    Render.drawChromaString("[Walking (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
                }
                if (!this.mc.thePlayer.capabilities.isFlying && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding() && this.mc.gameSettings.keyBindBack.isKeyDown() && !this.mc.gameSettings.keyBindRight.isKeyDown() && !this.mc.gameSettings.keyBindLeft.isKeyDown() && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                    Render.drawChromaString("[Walking (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
                }
                if (!this.mc.thePlayer.capabilities.isFlying && this.mc.gameSettings.keyBindRight.isKeyDown() && !this.mc.gameSettings.keyBindLeft.isKeyDown() && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                    Render.drawChromaString("[Strafing (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
                }
                if (!this.mc.thePlayer.isRiding() && this.mc.thePlayer.capabilities.isFlying) {
                    Render.drawChromaString("[Flying (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
                }
                if (!this.mc.thePlayer.capabilities.isFlying && !this.mc.gameSettings.keyBindRight.isKeyDown() && this.mc.gameSettings.keyBindLeft.isKeyDown() && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                    Render.drawChromaString("[Strafing (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
                }
                if (!this.mc.thePlayer.capabilities.isFlying && this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding()) {
                    Render.drawChromaString("[Sprinting (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
                }
                if (!this.mc.thePlayer.capabilities.isFlying && !this.mc.thePlayer.isSprinting() && !this.mc.thePlayer.isRiding() && this.mc.thePlayer.movementInput.moveForward <= 0.1 && !this.mc.gameSettings.keyBindBack.isKeyDown() && !this.mc.gameSettings.keyBindRight.isKeyDown() && !this.mc.gameSettings.keyBindLeft.isKeyDown()) {
                    Render.drawChromaString("[Standing (NoKeyHeld)]", pos.getAbsoluteX(), pos.getAbsoluteY(), false);
                }
            }
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
    
    @Override
    public void renderDummy(final ScreenPosition pos) {
        Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
        Render.drawChromaString("[Sprinting (Vanilla)]", pos.getAbsoluteX(), pos.getAbsoluteY(), true);
    }
}
