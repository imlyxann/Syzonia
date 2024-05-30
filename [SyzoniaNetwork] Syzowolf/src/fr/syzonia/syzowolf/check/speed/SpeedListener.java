package fr.syzonia.syzowolf.check.speed;



import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.syzonia.syzowolf.Main;
import fr.syzonia.syzowolf.SyzoPlayer;



public class SpeedListener implements Listener{

	public static final long tickrate = 20L;
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		
		if(!player.isOnline()) return;
		
		SyzoPlayer syzoplayer = Main.SyzoPlayers.get(player);
		
		if(hasMoved(event.getFrom(), event.getTo())) {			
			
			if(Bypass(player)) return;
			
			double x = Math.abs(player.getLocation().distance(syzoplayer.getLastLocationSpeed()));
			
		//	System.out.println(player.getName() + " --> " + x);
			
			if(x > MoveInfo.MaxSpeed && (System.currentTimeMillis() - syzoplayer.getLastMove()) > 50) {
				System.out.println("SpeedHack!");
			}
			
			// Sauvegarde du dernier mouvement du joueur
			syzoplayer.setLastMove(System.currentTimeMillis());
			
			syzoplayer.setLastLocationSpeed(player.getLocation());
		}
	}
	


	public boolean hasMoved(Location from, Location to) {
		if(from.getWorld() != to.getWorld()) return false;
		if(from.getX() < to.getX()) return true;
		if(from.getY() < to.getY()) return true;
		if(from.getZ() < to.getZ()) return true;
		return false;
	}
	
	public boolean Bypass(Player player) {
		if(player.getGameMode() == GameMode.CREATIVE) return true;
		if(player.isFlying()) return true;
		if(player.isInsideVehicle()) return true;
		return false;
 	}


	
	
	
}
