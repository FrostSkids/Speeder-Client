// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import Benz.hud.ScreenPosition;
import Benz.mods.ModDraggable;

public class ModKeyStrokes extends ModDraggable
{
    private ScreenPosition pos;
    private KeystrokesMode mode;
    
    public ModKeyStrokes() {
        this.mode = KeystrokesMode.WASD_SPRINT_MOUSE;
    }
    
    public void setMode(final KeystrokesMode mode) {
        this.mode = mode;
    }
    
    @Override
    public int getWidth() {
        return this.mode.getWidth();
    }
    
    @Override
    public int getHeight() {
        return this.mode.getHeight();
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        Key[] keys;
        for (int length = (keys = this.mode.getKeys()).length, i = 0; i < length; ++i) {
            final Key key = keys[i];
            final int textWidth = this.font.getStringWidth(key.getName());
            Gui.drawRect(pos.getAbsoluteX() + key.getX(), pos.getAbsoluteY() + key.getY(), pos.getAbsoluteX() + key.getX() + key.getWidth(), pos.getAbsoluteY() + key.getY() + key.getHeight(), key.isDown() ? new Color(255, 255, 255, 102).getRGB() : new Color(0, 0, 0, 102).getRGB());
            this.font.drawString(key.getName(), pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4, key.isDown() ? Color.BLACK.getRGB() : Color.PINK.getRGB());
        }
    }
    
    public enum KeystrokesMode
    {
        WASD("WASD", 0, new Key[] { Key.W, Key.A, Key.S, Key.D }), 
        WASD_MOUSE("WASD_MOUSE", 1, new Key[] { Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB }), 
        WASD_SPRINT("WASD_SPRINT", 2, new Key[] { Key.W, Key.A, Key.S, Key.D, new Key("---", Minecraft.getMinecraft().gameSettings.keyBindJump, 1, 45, 58, 18) }), 
        WASD_SPRINT_MOUSE("WASD_SPRINT_MOUSE", 3, new Key[] { Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB });
        
        private final Key[] keys;
        private int width;
        private int height;
        
        private KeystrokesMode(final String name, final int ordinal, final Key... keysIn) {
            this.width = 0;
            this.height = 0;
            this.keys = keysIn;
            Key[] keys;
            for (int length = (keys = this.keys).length, i = 0; i < length; ++i) {
                final Key key = keys[i];
                this.width = Math.max(this.width, key.getX() + key.getWidth());
                this.height = Math.max(this.height, key.getY() + key.getHeight());
            }
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public int getWidth() {
            return this.width;
        }
        
        public Key[] getKeys() {
            return this.keys;
        }
    }
    
    private static class Key
    {
        private static final Key W;
        private static final Key A;
        private static final Key S;
        private static final Key D;
        private static final Key LMB;
        private static final Key RMB;
        private final String name;
        private final KeyBinding keyBind;
        private final int x;
        private final int y;
        private final int width;
        private final int height;
        
        static {
            W = new Key("W", Minecraft.getMinecraft().gameSettings.keyBindForward, 21, 1, 18, 18);
            A = new Key("A", Minecraft.getMinecraft().gameSettings.keyBindLeft, 1, 21, 18, 18);
            S = new Key("S", Minecraft.getMinecraft().gameSettings.keyBindBack, 21, 21, 18, 18);
            D = new Key("D", Minecraft.getMinecraft().gameSettings.keyBindRight, 41, 21, 18, 18);
            LMB = new Key("LMB", Minecraft.getMinecraft().gameSettings.keyBindAttack, 1, 41, 28, 18);
            RMB = new Key("RMB", Minecraft.getMinecraft().gameSettings.keyBindUseItem, 31, 41, 28, 18);
        }
        
        public Key(final String name, final KeyBinding keyBind, final int x, final int y, final int width, final int height) {
            this.name = name;
            this.keyBind = keyBind;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        
        public boolean isDown() {
            return this.keyBind.isKeyDown();
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public String getName() {
            return this.name;
        }
        
        public int getWidth() {
            return this.width;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
}
