package fr.syzonia.hub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import fr.syzonia.hub.VirtualProfil.Lootboxs.VirtualLootBoxProfil;
import fr.syzonia.syzodb.hubjump.HubJumpManager;


public class UtilsListener implements Listener {

	@EventHandler
	public void creaturespawn(CreatureSpawnEvent event) {
		if(event.getSpawnReason() != SpawnReason.CUSTOM) {
			event.setCancelled(true);
		}
	} 
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.getAction() != null && event.getClickedBlock() == null) return;
		
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			
			if (event.getClickedBlock().getType() == Material.ENDER_CHEST) {
				event.setCancelled(true);
			}
			
			if (event.getClickedBlock().getType() == Material.WORKBENCH) {
				event.setCancelled(true);
			}
			
			if (event.getClickedBlock().getType() == Material.FURNACE) {
				event.setCancelled(true);
			}
			
			if (event.getClickedBlock().getType() == Material.TRAP_DOOR) {
				event.setCancelled(true);
			}
			
			if (event.getClickedBlock().getType().toString().contains("DOOR")) {
				event.setCancelled(true);
			}
			
			if (event.getClickedBlock().getType() == Material.NOTE_BLOCK) {
				event.setCancelled(true);
			}
			
			if (event.getClickedBlock().getType() == Material.WOOD_BUTTON) {
				event.setCancelled(true);
			}
			
			if (event.getClickedBlock().getType() == Material.STONE_BUTTON) {
				event.setCancelled(true);
			}
			
			if (event.getClickedBlock().getType() == Material.ANVIL) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void AntiCheatJump (PlayerInteractEvent ev) {
	if(ev.getAction().equals(Action.PHYSICAL)){
			if(ev.getClickedBlock().getType() == Material.STONE_PLATE || ev.getClickedBlock().getType() == Material.WOOD_PLATE){
				if(!new HubJumpManager().isInJump(ev.getPlayer().getUniqueId())) {
					ev.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void PlayerChestOpen(PlayerInteractEvent event) {
		if(event.getAction() != null && event.getClickedBlock() == null) return;
		
		if (event.getClickedBlock().getType() == Material.CHEST) {
			event.setCancelled(true);
			if(event.getClickedBlock().getLocation().equals(new Location(Bukkit.getWorld("world"), -13, 93, -9)) || event.getClickedBlock().getLocation().equals(new Location(Bukkit.getWorld("world"), -9, 93, -13)) || event.getClickedBlock().getLocation().equals(new Location(Bukkit.getWorld("world"), -11, 93, -11))) {
				new VirtualLootBoxProfil().open(event.getPlayer());
			}
		}
		
	}
	
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChunkUnload(ChunkUnloadEvent event)
    {
        event.setCancelled(true);
    }
    
	
}
