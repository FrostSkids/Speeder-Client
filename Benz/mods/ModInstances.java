// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods;

import Benz.hud.IRender;
import Benz.hud.HUDManager;
import Benz.mods.impl.ModFPSSpoof;
import Benz.mods.impl.ModPerspective;
import Benz.mods.impl.ModClearWater;
import Benz.mods.impl.ModFullbright;
import Benz.mods.impl.ModCPS;
import Benz.mods.impl.ModKeyStrokes;
import Benz.mods.impl.ModFPS;
import Benz.mods.impl.ModWalkText;
import Benz.mods.impl.ModEquippedItem;
import Benz.mods.impl.ModArmorStatus;
import Benz.mods.impl.PingMod;
import Benz.mods.impl.ModPosition;

public class ModInstances
{
    public static final boolean NoLag = true;
    private static ModPosition modPosition;
    private static PingMod pingMod;
    private static ModArmorStatus modArmorStatus;
    private static ModEquippedItem modEquippedItem;
    private static ModWalkText modWalkText;
    private static ModFPS modFPS;
    private static ModKeyStrokes modKeyStrokes;
    private static ModCPS modCPS;
    private static ModFullbright modFullbright;
    private static ModClearWater modClearWater;
    private static ModPerspective modPerspective;
    private static ModFPSSpoof modFPSSpoof;
    
    public static void register(final HUDManager api) {
        ModInstances.modPosition = new ModPosition();
        api.register(ModInstances.modPosition);
        ModInstances.pingMod = new PingMod();
        api.register(ModInstances.pingMod);
        ModInstances.modArmorStatus = new ModArmorStatus();
        api.register(ModInstances.modArmorStatus);
        ModInstances.modEquippedItem = new ModEquippedItem();
        api.register(ModInstances.modEquippedItem);
        ModInstances.modWalkText = new ModWalkText();
        api.register(ModInstances.modWalkText);
        ModInstances.modFPS = new ModFPS();
        api.register(ModInstances.modFPS);
        ModInstances.modKeyStrokes = new ModKeyStrokes();
        api.register(ModInstances.modKeyStrokes);
        ModInstances.modCPS = new ModCPS();
        api.register(ModInstances.modCPS);
        ModInstances.modFullbright = new ModFullbright();
        api.register(ModInstances.modFullbright);
        ModInstances.modClearWater = new ModClearWater();
        api.register(ModInstances.modClearWater);
        ModInstances.modPerspective = new ModPerspective();
        api.register(ModInstances.modPerspective);
        ModInstances.modFPSSpoof = new ModFPSSpoof();
        api.register(ModInstances.modFPSSpoof);
    }
    
    public static ModPosition getModPosition() {
        return getModPosition();
    }
    
    public static PingMod getPingMod() {
        return getPingMod();
    }
    
    public static ModArmorStatus getModArmorStatus() {
        return getModArmorStatus();
    }
    
    public static ModEquippedItem getModEquippedItem() {
        return getModEquippedItem();
    }
    
    public static ModWalkText geModWalkText() {
        return geModWalkText();
    }
    
    public static ModFPS getModFPS() {
        return getModFPS();
    }
    
    public static ModKeyStrokes getModKeyStrokes() {
        return getModKeyStrokes();
    }
    
    public static ModCPS getModCPS() {
        return getModCPS();
    }
    
    public static ModFullbright getModFullbright() {
        return getModFullbright();
    }
    
    public static ModClearWater getModClearWater() {
        return getModClearWater();
    }
    
    public static ModPerspective getModPerspective() {
        return getModPerspective();
    }
    
    public static ModFPSSpoof getModFPSSpoof() {
        return getModFPSSpoof();
    }
}
