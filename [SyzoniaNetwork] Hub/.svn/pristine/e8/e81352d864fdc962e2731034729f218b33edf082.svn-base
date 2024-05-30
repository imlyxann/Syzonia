package fr.syzonia.hub.runnable.divers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.syzonia.hub.msg.HubMsg;

public class MessageRunnable extends BukkitRunnable{

	public static int timer = 0;
	
	@Override
	public void run() {
		timer++;
		
		if(timer == 256) {
			for(Player players : Bukkit.getOnlinePlayers()) {
				players.sendMessage("");
				players.sendMessage("§b-----------------------------------------");
				players.sendMessage("");
				players.sendMessage("§e§lPromos sur toutes la Boutiques! §f» §o§d-50%");
				players.sendMessage("§6§nhttps://store.syzonia.fr");
				players.sendMessage("");
				players.sendMessage("§b-----------------------------------------");
				players.sendMessage("");
			}
		}
		
		if(timer == 512) {
			for(Player players : Bukkit.getOnlinePlayers()) {
				players.sendMessage("");
				players.sendMessage(HubMsg.MESSAGEBAR.getName());
				players.sendMessage("§dYoutube §f» §6§nhttps://youtube.com/@syzonia");
				players.sendMessage("§dDiscord §f» §6§ndsc.gg/syzonia");
				players.sendMessage(HubMsg.MESSAGEBAR.getName());
				players.sendMessage("");
				timer = 0;
			}
		}
		

		
		
	}

	
	
}
