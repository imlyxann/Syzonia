package fr.syzonia.hub.VirtualGame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.syzonia.hub.VirtualGame.cakewars.VirtualGameCakeWars;
import fr.syzonia.hub.VirtualGame.cakewars.servers.ServersCakeMenu;

public class VirtualGameListener {

	PluginManager pm;
	Plugin plugin;
	
	public VirtualGameListener(Plugin plugin) {
		this.plugin = plugin;
		this.pm = Bukkit.getPluginManager();
	}
	
	public void registerGameListeners() {
		pm.registerEvents(new VirtualGameCakeWars(), plugin);
		pm.registerEvents(new ServersCakeMenu(), plugin);
	}
	
}
