/*******************************************************************************
 * HudPixel Reloaded (github.com/palechip/HudPixel), an unofficial Minecraft Mod for the Hypixel Network
 *
 * Copyright (c) 2014-2015 palechip (twitter.com/palechip) and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *******************************************************************************/
package com.palechip.hudpixelmod.chat;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

import com.palechip.hudpixelmod.config.HudPixelConfig;
import com.palechip.hudpixelmod.util.ChatMessageComposer;

import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class LobbyCommandAutoCompleter {
    public static final String LOBBY_CONFIRMATION_MESSAGE = "Are you sure? Type /lobby again if you really want to quit.";

    public LobbyCommandAutoCompleter() {
    	
    }
    
    public void onChatReceived(ClientChatReceivedEvent event) {
    	    String message = event.message.getUnformattedText();
        // get the message asking for /lobby as confirmation
        if(HudPixelConfig.autoCompleteSecondLobbyCmd && message.equals(LOBBY_CONFIRMATION_MESSAGE)) {
             Minecraft.getMinecraft().thePlayer.sendChatMessage("/lobby");
             new ChatMessageComposer("Automatically sending lobby for confirmation!", EnumChatFormatting.GREEN).send();
             //delete the original message.
            event.setCanceled(true);
            
            return;
        }
    }
}
