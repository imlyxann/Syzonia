package fr.syzonia.syzodb.Lydrageanas;




import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.syzonia.syzodb.Main;
import fr.syzonia.syzodb.server.Servers;

public class LydraCommand extends BukkitRunnable{

	public static int ServerStatus = 0;
	
	@Override
	public void run() {

		switch (new Servers(Bukkit.getServerName()).getStatus()) {
		case 0:
			
			// Fermeture
			
			new Servers(Bukkit.getServerName()).setStatus(0);
			setServerStatus(new Servers(Bukkit.getServerName()).getStatus());
			Bukkit.getServer().shutdown();
			
			break;

		case 1:
			
			// Allumage
			
			new Servers(Bukkit.getServerName()).setStatus(1);
			setServerStatus(new Servers(Bukkit.getServerName()).getStatus());
			StartContinue();
			
			break;
			
		case 2:
			
			// Reload
			
			new Servers(Bukkit.getServerName()).setStatus(2);
			setServerStatus(new Servers(Bukkit.getServerName()).getStatus());
			Bukkit.getServer().reload();
			
			break;
			
		case 3:
			
			// Maintenance
			
			new Servers(Bukkit.getServerName()).setStatus(3);
			setServerStatus(new Servers(Bukkit.getServerName()).getStatus());
			Maintenance();
			
			break;

		default:
			break;
		}
		
		
	}
	
	public void StartContinue() {
		if(new Servers(Bukkit.getServerName()).getStatus() > 3) {
			new Servers(Bukkit.getServerName()).setStatus(1);
		}
	}
	
	public void Maintenance() {
		for(Player player : Bukkit.getOnlinePlayers()) {
			player.kickPlayer("§cMaintenance");
		}
		
		if(Main.database.isOnline()) Main.database.deconnexion();
	}
	
	public static void setServerStatus(int serverStatus) {
		ServerStatus = serverStatus;
	}
	
	public static int getServerStatus() {
		return ServerStatus;
	}
	
	
}
