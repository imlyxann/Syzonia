package fr.syzonia.hub.pets;

import java.util.HashMap;

import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.syzonia.hub.pets.pets.MiniDiamond;
import fr.syzonia.hub.pets.pets.MiniPlayerPet;

public class PetsManager implements Listener {

	public static Map<Player, ArmorStand> PlayerPets = new HashMap<>();
	
	public PetsManager() {}
	
	public void spawnMiniPet(Player player) {
		new MiniPlayerPet().spawn(player);
	}
	
	public void killMiniPet(Player player) {
		new MiniPlayerPet().killPet(player);
	}
	
	public void spawnMiniDiamond(Player player) {
		new MiniDiamond().spawn(player);
	}
	
	public void killMiniDiamond(Player player) {
		new MiniDiamond().killPet(player);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();

		if(PetsManager.PlayerPets.containsKey(p)) {
			PetsManager.PlayerPets.get(p).teleport(getLoc(p));
		}
	}
	
	@EventHandler
	public void PlayerInteract(PlayerInteractEntityEvent event) {
		if(event.getRightClicked() instanceof ArmorStand) {
			event.setCancelled(true);
		}
	}
	
	public Location getLoc(Player p) {		
        Location petLoc = p.getLocation();
        petLoc.setPitch(0.0F);
        petLoc.setYaw(petLoc.getYaw() + 50.0F);
        petLoc.add(petLoc.getDirection().normalize().multiply(1.2D));
        petLoc.add(0.0D, 1.3D, 0.0D);
        petLoc.setYaw(p.getLocation().getYaw());
        petLoc.setPitch(p.getLocation().getPitch());

        return petLoc;
	}
	
	
	
}
