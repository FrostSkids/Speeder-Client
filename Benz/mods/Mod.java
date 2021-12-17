// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods;

import Benz.event.EventManager;
import Benz.Client;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.Minecraft;

public class Mod
{
    private boolean isEnabled;
    private boolean isDisable;
    protected final Minecraft mc;
    protected final FontRenderer font;
    protected final Client client;
    
    public Mod() {
        this.isEnabled = true;
        this.isDisable = false;
        this.mc = Minecraft.getMinecraft();
        this.font = this.mc.fontRendererObj;
        this.client = Client.getInstance();
        this.setEnabled(this.isEnabled);
        this.setDisable(this.isDisable);
    }
    
    public void setEnabled(final boolean isEnabled) {
        this.isEnabled = isEnabled;
        if (isEnabled) {
            EventManager.register(this);
        }
        else {
            EventManager.unregister(this);
        }
    }
    
    public void setDisable(final boolean isDisable) {
        this.isDisable = isDisable;
        if (isDisable) {
            EventManager.unregister(this);
        }
        else {
            EventManager.register(this);
        }
    }
    
    public boolean isEnabled() {
        return this.isEnabled;
    }
    
    public boolean isDisable() {
        return this.isDisable;
    }
}
