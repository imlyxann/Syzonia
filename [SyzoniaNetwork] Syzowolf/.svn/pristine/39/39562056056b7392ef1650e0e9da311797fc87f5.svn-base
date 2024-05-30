package fr.syzonia.syzowolf;

import java.util.HashMap;



import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.syzonia.syzowolf.commandes.SyzoWolfCommand;
import fr.syzonia.syzowolf.listeners.ListenersManager;

public class Main extends JavaPlugin{

	public static Main Instance;
	public static HashMap<Player, SyzoPlayer> SyzoPlayers = new HashMap<>();
	
	public static int speedViolations = 15;
	
	@Override
	public void onLoad() { Instance = this; }
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		this.getConfig().set("devmod", true);
		
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		new ListenersManager().loadListeners(Instance);
		Instance.getCommand("syzowolf").setExecutor(new SyzoWolfCommand());
		
	}
	
	@Override
	public void onDisable() {
	}
	
}
