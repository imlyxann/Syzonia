package fr.syzonia.hub.listeners.game;


import org.bukkit.Bukkit;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.syzonia.syzodb.Main;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.mysql.gadget.UseGadget;
import fr.syzonia.syzodb.mysql.mount.UseMount;
import fr.syzonia.syzodb.mysql.particules.UseParticules;
import fr.syzonia.syzodb.mysql.pet.UsePet;
import fr.syzonia.syzodb.mysql.queue.QueueManager;
import fr.syzonia.syzodb.mysql.vetements.UseVetements;
import fr.syzonia.syzodb.rank.Syzorank;
import fr.syzonia.syzodb.server.Servers;
import fr.syzonia.hub.pets.PetsManager;

public class PlayerQuitListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
		
		if(Main.database.isBanned(player.getUniqueId())) {
			event.setQuitMessage(null);
			return;
		}

		
		Servers.removePlayer(player.getName(), Bukkit.getServerName());
		
		switch (new UsePet().getPetInUse(player.getUniqueId())) {
		case 1:
			
			new PetsManager().killMiniPet(player);
			
			break;
			
		case 2:
			
			new PetsManager().killMiniDiamond(player);
			
			break;

		default:
			break;
		}
		
		if(new UseMount().getMountInUse(player.getUniqueId()) > 0) {
			Entity entity = event.getPlayer().getVehicle();
			
			entity.remove();
		}
		
		new QueueManager().removePlayer(player);
		
		new UseVetements().setChapeauxInUse(player.getUniqueId(), 0);
		new UseVetements().setPullUse(player.getUniqueId(), 0);
		new UseVetements().setPantalonUse(player.getUniqueId(), 0);
		new UseVetements().setChaussuresUse(player.getUniqueId(), 0);
		new UseGadget().setGadgetInUse(player.getUniqueId(), 0);
		new UseParticules().setParticulesUse(player.getUniqueId(), 0);
		new UseMount().setMountInUse(player.getUniqueId(), 0);
		new UsePet().setPetInUse(player.getUniqueId(), 0);
		new UseParticules().setParticulesUse(player.getUniqueId(), 0);
		
		event.setQuitMessage(new Syzorank(playerinfo.getRank()).getDisplayName(player.getUniqueId()) + " " + event.getPlayer().getName() + " §6§oa quitté le Hub..");
		player.getInventory().clear();
		
		player.getInventory().setHelmet(null);
		player.getInventory().setChestplate(null);
		player.getInventory().setLeggings(null);
		player.getInventory().setBoots(null);
	}
    
	
   
}