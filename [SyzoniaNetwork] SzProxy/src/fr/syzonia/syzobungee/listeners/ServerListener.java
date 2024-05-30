package fr.syzonia.syzobungee.listeners;

import fr.syzonia.syzobungee.player.ServerName;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerListener implements Listener {

	@EventHandler
	public void Server(ServerConnectEvent event) {
		ServerName.setServerName(event.getPlayer().getUniqueId(), event.getTarget().getName());
	}
	
}
