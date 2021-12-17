// 
// Decompiled by Procyon v0.5.36
// 

package Benz.event;

import java.util.Iterator;
import java.util.ArrayList;

public class Event
{
    public Event call() {
        final ArrayList<EventData> dataList = EventManager.get(this.getClass());
        if (dataList != null) {
            for (final EventData data : dataList) {
                try {
                    data.target.invoke(data.source, this);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
