// 
// Decompiled by Procyon v0.5.36
// 

package Benz.event;

import java.lang.reflect.Method;

public class EventData
{
    public final Object source;
    public final Method target;
    public final byte priority;
    
    public EventData(final Object source, final Method target, final byte Priority) {
        this.source = source;
        this.target = target;
        this.priority = Priority;
    }
}
