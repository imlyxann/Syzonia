package fr.syzonia.hub.scoreboard;


import java.util.HashMap;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.syzonia.core.coins.CoinsUtils;
import fr.syzonia.core.rank.RankUtils;
import fr.syzonia.core.scoreboard.ScoreboardSign;
import fr.syzonia.syzodb.mysql.host.HostTicket;

public class ScoreboardManager {

	public Player player;
	public ScoreboardSign scoreboardSign;
	public static HashMap<Player, ScoreboardSign> scoreboardGame = new HashMap<>();
	
  	public ScoreboardManager(Player player) {
  		this.player = player;
  		this.scoreboardSign = new ScoreboardSign(player, player.getName());
  		scoreboardGame.put(player, this.scoreboardSign);
  	}
 
  	public void loadScoreboard() {
  		this.scoreboardSign.setObjectiveName(ChatColor.YELLOW + " " + ChatColor.GOLD + ChatColor.BOLD  + "Syzonia");
  		this.scoreboardSign.create();

  		((ScoreboardSign) scoreboardGame.get(player)).setLine(9,  "§8");
  		((ScoreboardSign) scoreboardGame.get(player)).setLine(8,  "§7Rank: " +  new RankUtils().getPlayerRank(player));
		((ScoreboardSign) scoreboardGame.get(player)).setLine(7,  "§7Syzocoins: " + "§d" + ChatColor.BOLD + CoinsUtils.playerCoinsLevel(player));
  		((ScoreboardSign) scoreboardGame.get(player)).setLine(6,  "§7Host: " +  ChatColor.GOLD + new HostTicket().getHostTicket(player.getUniqueId()).toString().substring(2));
  		((ScoreboardSign) scoreboardGame.get(player)).setLine(5,  "§8");
  		((ScoreboardSign) scoreboardGame.get(player)).setLine(4,  "§7Hub: " + "§a#" + Bukkit.getServerId() );
  		((ScoreboardSign) scoreboardGame.get(player)).setLine(3,  "§7Joueurs: " + ChatColor.AQUA + Bukkit.getOnlinePlayers().size());
  		((ScoreboardSign) scoreboardGame.get(player)).setLine(2,  "§1");
  	}
  	
  
}