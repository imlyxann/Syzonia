package fr.syzonia.hub.player;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.syzonia.hub.scoreboard.ScoreboardManager;

public class SyzoniaPlayer {



	private String name;
	
	public Player player;

	public static Map<String, SyzoniaPlayer> gamePlayers = new HashMap<>();
	public ScoreboardManager scoreboard;
	
	public SyzoniaPlayer(String name) {
		this.name = name;

		scoreboard = new ScoreboardManager(Bukkit.getPlayer(name));
		gamePlayers.put(name, this);
	}
	
	public String getName() {
		return name;
	}
	
}
