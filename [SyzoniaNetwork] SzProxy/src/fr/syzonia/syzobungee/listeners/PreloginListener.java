package fr.syzonia.syzobungee.listeners;

import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PreloginListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void PreLogin(PreLoginEvent event) {
		System.out.println("Adding the player {" + event.getConnection().getName() + "} with ip: " 	+ event.getConnection().getAddress());
	}
	
}
