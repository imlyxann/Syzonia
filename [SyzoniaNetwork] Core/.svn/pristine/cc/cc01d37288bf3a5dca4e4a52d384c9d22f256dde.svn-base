package fr.syzonia.core.syzowolf;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class SyzoWolfUtils {

	public void stop(Plugin plugin) {
		if(plugin != null) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "syzowolf stop");
		}
	}
	
	public void start(Plugin plugin) {
		if(plugin != null) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "syzowolf start");
		}
	}
	
	public void sendReport(Plugin plugin, String player, String Reason) {
		if(plugin != null) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "syzowolf report " + player + " " + Reason);
		}
	}
	
}
