// 
// Decompiled by Procyon v0.5.36
// 

package Benz.event.impl;

import Benz.event.EventCancelable;

public class KeyEvent extends EventCancelable
{
    private final int key;
    
    public KeyEvent(final int key) {
        this.key = key;
    }
    
    public int getkey() {
        return this.key;
    }
}
