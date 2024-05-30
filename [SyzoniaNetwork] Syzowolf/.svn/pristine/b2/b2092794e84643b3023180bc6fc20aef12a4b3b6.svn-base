package fr.syzonia.syzowolf.listeners;

import org.bukkit.Bukkit;


import org.bukkit.plugin.PluginManager;

import fr.syzonia.syzowolf.Main;
import fr.syzonia.syzowolf.check.speed.SpeedListener;
import fr.syzonia.syzowolf.listeners.player.PlayerListener;

public class ListenersManager {

	public void loadListeners(Main main) {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerListener(), main);
		pm.registerEvents(new SpeedListener(), main);
	}
}
