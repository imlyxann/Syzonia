package fr.syzonia.hub.runnable;

import org.bukkit.Bukkit;



import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import fr.syzonia.hub.Hub;

public class MainRunnable {

	public static int Timer = 0;
	
	public Player player;
	BukkitTask task;
	
	
	public MainRunnable(Player player) {
		this.player = player;
	}
	
	public void run() {
		
		task = Bukkit.getScheduler().runTaskTimer(Hub.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if(player.isOnline()) {		

					Timer++;		
				
					Bukkit.getWorld("world").setPVP(false);
					Bukkit.getWorld("world").setStorm(false);
					Bukkit.getWorld("world").setTime(1000);
					Bukkit.getWorld("world").setGameRuleValue("doDaylightCycle", "false");
					player.setFoodLevel(20);
					player.setHealth(20);
					player.setLevel(Bukkit.getOnlinePlayers().size());
					
				} else {
					task.cancel();
				}
			}
		}, 0L, 20L);
		
		
	}

}
