// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

public class ClientThread extends Thread
{
    private boolean isRunning;
    
    public ClientThread() {
        this.isRunning = false;
    }
    
    @Override
    public void run() {
        this.isRunning = true;
        while (this.isRunning) {
            System.gc();
            System.out.println("Running garbage collector.");
            try {
                Thread.sleep(1500000L);
            }
            catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }
    }
    
    public void shutdown() {
        this.isRunning = false;
    }
}
