package fr.syzonia.hub.runnable;

import org.bukkit.Bukkit;

import org.bukkit.entity.Player;


import org.bukkit.scheduler.BukkitTask;

import fr.syzonia.syzodb.server.Servers;
import fr.syzonia.hub.Hub;
import fr.syzonia.hub.player.SyzoniaPlayer;

public class ScoreboardLoadRunnable{

	public Player player;
	BukkitTask task;

	
	public ScoreboardLoadRunnable(Player player) {
		this.player = player;
	}
	
	public void run() {
		
		task = Bukkit.getScheduler().runTaskTimer(Hub.getInstance(), new Runnable() {
			
			@Override
			public void run() {

				
				if(Servers.getPlayers(Bukkit.getServerName()).contains(player.getName())) {
					SyzoniaPlayer.gamePlayers.get(player.getName()).scoreboard.loadScoreboard();
				} else {
					task.cancel();
				}
				
			}
		}, 0L, 1L);
	}


	
}
