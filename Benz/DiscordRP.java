// 
// Decompiled by Procyon v0.5.36
// 

package Benz;

import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import net.arikia.dev.drpc.DiscordEventHandlers;

public class DiscordRP
{
    private boolean running;
    private long created;
    
    public DiscordRP() {
        this.running = true;
        this.created = 0L;
    }
    
    public void start() {
        this.created = System.currentTimeMillis();
        final DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
            @Override
            public void apply(final DiscordUser user) {
                System.out.println("Welcome " + user.username + "#" + user.discriminator + ".");
                DiscordRP.this.update("Booting up...", "");
            }
        }).build();
        DiscordRPC.discordInitialize("805614134582181888", handlers, true);
        new Thread("Discord RPC Callback") {
            @Override
            public void run() {
                DiscordRPC.discordRunCallbacks();
            }
        }.start();
    }
    
    public void shutdown() {
        this.running = false;
        DiscordRPC.discordShutdown();
    }
    
    public void update(final String firstline, final String secondline) {
        final DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondline);
        b.setBigImage("large", "");
        b.setDetails(firstline);
        b.setStartTimestamps(this.created);
        DiscordRPC.discordUpdatePresence(b.build());
    }
}
