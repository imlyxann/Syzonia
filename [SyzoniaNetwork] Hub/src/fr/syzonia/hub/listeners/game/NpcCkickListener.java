package fr.syzonia.hub.listeners.game;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.syzonia.core.npc.NpcManager;
import fr.syzonia.hub.VirtualGame.cakewars.VirtualGameCakeWars;
import fr.syzonia.hub.events.NpcRightClickEvent;

public class NpcCkickListener implements Listener{

	@EventHandler
	public void Click(NpcRightClickEvent event) {
		switch (NpcManager.METADATACUSTOM.get(event.getNpc())) {
		case "N1":
			
			new VirtualGameCakeWars().Open(event.getPlayer());
			
			break;
			
		case "E1":
			
			Bukkit.broadcastMessage("Test");
			
			
			break;

		default:
			break;
		}
		
	}
	
}
