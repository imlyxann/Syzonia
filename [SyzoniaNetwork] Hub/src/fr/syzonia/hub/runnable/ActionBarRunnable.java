package fr.syzonia.hub.runnable;


import org.bukkit.Bukkit;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import fr.syzonia.hub.Hub;
import fr.syzonia.hub.actionbar.ActionBar;

public class ActionBarRunnable {

	Player player;
	ActionBar bar;
	BukkitTask task;
	
	public ActionBarRunnable(Player player) {
		this.player = player;
		ActionBar bar = new ActionBar(player);
		this.bar = bar;
	}
	
	
	
	public void run() {	
		
		task = Bukkit.getScheduler().runTaskTimer(Hub.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if(player.isOnline()) {
					
					ActionBar.sendActionBar(player, bar.NextMessage());
				
				} else {
					task.cancel();
				}
				
			}
		}, 0, 60);
	}

}
