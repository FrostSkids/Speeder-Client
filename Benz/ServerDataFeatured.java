// 
// Decompiled by Procyon v0.5.36
// 

package Benz;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.multiplayer.ServerData;

public class ServerDataFeatured extends ServerData
{
    public static final ResourceLocation SIN_ICON;
    
    static {
        SIN_ICON = new ResourceLocation("Benz/Sin.png");
    }
    
    public ServerDataFeatured(final String ServerName, final String ServerIP) {
        super(ServerName, ServerIP, false);
    }
}
