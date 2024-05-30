package fr.syzonia.syzobungee.listeners;

import java.util.Random;

import fr.syzonia.syzobungee.Main;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerPingListener implements Listener {

    @EventHandler
	public void onPing(ProxyPingEvent event) {

    
    	
        ServerPing ping = event.getResponse();

        ping.setDescriptionComponent(new TextComponent("         §6§lSyzonia §e[1.8] §f» §ahttps://syzonia.fr\n            §3» §eTombola Monture §d&& §bEvent CakeWars §3«"));

        if(Main.Maintenance == 1) {
        	event.getResponse().setVersion(new ServerPing.Protocol( "§4Maintenance...", 3));
        }
        
        /*
        if(Main.soon = true && Main.Maintenance == 0) {
        	event.getResponse().setVersion(new ServerPing.Protocol( "§cBientôt!", 3));
        }
        
        */
        
        Random r = new Random();
        int low = 9500;
        int high = 10000;
        int result = r.nextInt(high-low) + low;
        
        event.getResponse().setPlayers(new ServerPing.Players(10000, result, null));
        
        event.setResponse(ping);
    }
}
