// 
// Decompiled by Procyon v0.5.36
// 

package Benz;

import net.minecraft.client.gui.GuiScreen;
import Benz.gui.GuiModToggle;
import Benz.event.EventTarget;
import net.minecraft.client.Minecraft;
import Benz.event.impl.ClientTickEvent;
import Benz.mods.ModInstances;
import Benz.event.EventManager;
import Benz.hud.HUDManager;

public class Client
{
    private static final Client INSTANCE;
    private DiscordRP discordRP;
    private HUDManager hudManager;
    
    static {
        INSTANCE = new Client();
    }
    
    public Client() {
        this.discordRP = new DiscordRP();
    }
    
    public static final Client getInstance() {
        return Client.INSTANCE;
    }
    
    public void init() {
        FileManager.init();
        this.discordRP.start();
        EventManager.register(this);
    }
    
    public void start() {
        ModInstances.register(this.hudManager = HUDManager.getInstance());
    }
    
    public void shutdown() {
        this.discordRP.shutdown();
    }
    
    public DiscordRP getDiscordRP() {
        return this.discordRP;
    }
    
    @EventTarget
    public void onTick(final ClientTickEvent e) {
        if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
            this.hudManager.openConfigScreen();
        }
    }
    
    @EventTarget
    public void onTick1(final ClientTickEvent e) {
        if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiModToggle());
        }
    }
}
