package fr.syzonia.core;

import org.bukkit.Bukkit;



import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.syzonia.core.server.ServerComponent;

public class Main extends JavaPlugin{

	public static Main Instance;
	
	@Override
	public void onLoad() { Instance = this; }
	
	@Override
	public void onEnable() {
		
		System.out.println("[Core] Starting...");
		
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		System.out.println("[Core] Core is start!");
		
		if(new ServerComponent().isFake()) {
			for(Player players : Bukkit.getOnlinePlayers()) {
				players.sendMessage("§eUtilisation de §dSyzonia-db: " + (Bukkit.getPluginManager().isPluginEnabled("Syzonia-db") ? "§atrue" : "§cfalse"));
				players.sendMessage("§eUtilisation de §dCore: " + (Bukkit.getPluginManager().isPluginEnabled("Core") ? "§atrue" : "§cfalse"));
			}
		}
		
	}
	
	@Override
	public void onDisable() {}
}
