// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import Benz.hud.ScreenPosition;
import org.lwjgl.opengl.Display;
import Benz.event.EventTarget;
import org.lwjgl.input.Keyboard;
import Benz.event.impl.KeyEvent;
import Benz.mods.ModDraggable;

public class ModPerspective extends ModDraggable
{
    private boolean returnOnRelease;
    private boolean perspectiveToggled;
    private float cameraYaw;
    private float cameraPitch;
    private int prevPerspective;
    
    public ModPerspective() {
        this.returnOnRelease = true;
        this.perspectiveToggled = false;
        this.cameraYaw = 0.0f;
        this.cameraPitch = 0.0f;
        this.prevPerspective = 0;
    }
    
    @EventTarget
    public void keyEvent(final KeyEvent e) {
        if (Keyboard.getEventKey() == this.mc.gameSettings.CLIENT_360_VIEW.getKeyCode()) {
            if (Keyboard.getEventKeyState()) {
                this.perspectiveToggled = !this.perspectiveToggled;
                this.cameraYaw = this.mc.thePlayer.rotationYaw;
                this.cameraPitch = this.mc.thePlayer.rotationPitch;
                if (this.perspectiveToggled) {
                    this.prevPerspective = this.mc.gameSettings.thirdPersonView;
                    this.mc.gameSettings.thirdPersonView = 1;
                }
                else {
                    this.mc.gameSettings.thirdPersonView = this.prevPerspective;
                }
            }
            else if (this.returnOnRelease) {
                this.perspectiveToggled = false;
                this.mc.gameSettings.thirdPersonView = this.prevPerspective;
            }
        }
        if (Keyboard.getEventKey() == this.mc.gameSettings.keyBindTogglePerspective.getKeyCode()) {
            this.perspectiveToggled = false;
        }
    }
    
    public float getCameraYaw() {
        return this.perspectiveToggled ? this.cameraYaw : this.mc.thePlayer.rotationYaw;
    }
    
    public float getCameraPitch() {
        return this.perspectiveToggled ? this.cameraPitch : this.mc.thePlayer.rotationPitch;
    }
    
    public boolean mouseHack() {
        if (this.mc.inGameHasFocus && Display.isActive()) {
            if (!this.perspectiveToggled) {
                return true;
            }
            this.mc.mouseHelper.mouseXYChange();
            final float f1 = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float f2 = f1 * f1 * f1 * 8.0f;
            final float f3 = this.mc.mouseHelper.deltaX * f2;
            final float f4 = this.mc.mouseHelper.deltaY * f2;
            this.cameraYaw += f3 * 0.15f;
            this.cameraPitch += f4 * 0.15f;
            if (this.cameraPitch > 90.0f) {
                this.cameraPitch = 90.0f;
            }
            if (this.cameraYaw < -90.0f) {
                this.cameraYaw = -90.0f;
            }
        }
        return false;
    }
    
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
    }
}
