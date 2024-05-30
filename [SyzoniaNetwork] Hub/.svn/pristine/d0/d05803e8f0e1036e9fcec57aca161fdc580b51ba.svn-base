package fr.syzonia.hub.particules.listener;

import org.bukkit.Effect;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.syzonia.syzodb.mysql.particules.UseParticules;
import fr.syzonia.hub.particules.ParticulesManager;



public class PlayerParticulesMoveListener implements Listener{

	@EventHandler
	public void PlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		
		if(new UseParticules().getParticulesInUse(player.getUniqueId()) == 1) {
        	new ParticulesManager().spawnParticles(Effect.LAVA_POP, 6, player.getLocation());
    	}
		
		if(new UseParticules().getParticulesInUse(player.getUniqueId()) == 2) {
        	new ParticulesManager().spawnParticles(Effect.SMOKE, 6, player.getLocation());
    	}
		
		if(new UseParticules().getParticulesInUse(player.getUniqueId()) == 3) {
			
			new ParticulesManager().spawnParticles(Effect.HEART, 0, player.getLocation());	
		}	
		
		if(new UseParticules().getParticulesInUse(player.getUniqueId()) == 4) {
			new ParticulesManager().spawnParticles(Effect.HAPPY_VILLAGER, 6, player.getLocation());
			
		}
		
	}
	
	
}
