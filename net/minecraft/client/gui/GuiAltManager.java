// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.awt.Color;
import net.minecraft.util.Session;
import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.net.Proxy;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import java.io.IOException;
import net.minecraft.client.resources.I18n;

public class GuiAltManager extends GuiScreen
{
    private GuiScreen parent;
    private String status;
    private GuiTextField loginField;
    
    public GuiAltManager(final GuiScreen guiMainMenu) {
        this.parent = guiMainMenu;
    }
    
    @Override
    public void initGui() {
        this.status = "waiting...";
        final int width = 100;
        final int height = 20;
        final int offset = 2;
        this.buttonList.add(new GuiButton(0, this.width / 2 - width / 2, this.height - height - offset, width, height, "Log In"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - width / 2, this.height - (height + offset) * 2, width, height, I18n.format("gui.back", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 - width / 2, this.height - (height + offset) * 3, width, height, I18n.format("Alt Help", new Object[0])));
        (this.loginField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, this.height / 4, 200, 20)).setFocused(true);
        this.loginField.setText("");
    }
    
    @Override
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException {
        this.loginField.textboxKeyTyped(typedChar, keyCode);
        if (keyCode == 1) {
            this.mc.displayGuiScreen(this.parent);
            this.actionPerformed(this.buttonList.get(1));
        }
        if (keyCode == 28) {
            this.actionPerformed(this.buttonList.get(0));
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        if (button.id == 0) {
            if (this.loginField.getText() != null && !this.loginField.getText().isEmpty()) {
                if (!this.loginField.getText().contains(" ")) {
                    try {
                        final String[] args = this.loginField.getText().split(":");
                        if (args[0].contains("@")) {
                            final YggdrasilUserAuthentication authentication = (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
                            authentication.setUsername(args[0]);
                            authentication.setPassword(args[1]);
                            try {
                                authentication.logIn();
                                this.mc.session = new Session(authentication.getSelectedProfile().getName(), authentication.getSelectedProfile().getId().toString(), authentication.getAuthenticatedToken(), "mojang");
                                System.out.println(this.status = "Logged In As " + this.mc.session.getUsername());
                            }
                            catch (Exception e) {
                                System.out.println(this.status = "ERROR: INVALID EMAIL OR PASSWORD");
                            }
                        }
                        else {
                            System.out.println(this.status = "ERROR: ALT IS NOT PREMIUM");
                        }
                    }
                    catch (Exception e2) {
                        System.out.println(this.status = "ERROR: INVALID EMAIL OR PASSWORD");
                    }
                }
                else {
                    System.out.println(this.status = "ERROR: INVALID EMAIL OR PASSWORD");
                }
            }
            else {
                System.out.println(this.status = "ERROR: INVALID EMAIL OR PASSWORD");
            }
        }
        else if (button.id == 1) {
            this.mc.displayGuiScreen(this.parent);
        }
        else if (button.id == 4) {
            System.out.println(this.status = "Format Like This: Email@gmail.com:Password");
        }
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Alt Log in ", this.width / 2, 10, Color.WHITE.getRGB());
        this.drawCenteredString(this.fontRendererObj, this.status, this.width / 2, 20, Color.WHITE.getRGB());
        this.loginField.drawTextBox();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void updateScreen() {
        this.loginField.updateCursorCounter();
    }
}
