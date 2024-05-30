package fr.syzonia.hub.actionbar;


import java.util.ArrayList;

import java.util.List;

import org.bukkit.entity.Player;

import fr.syzonia.core.title.Title;

public class ActionBar {

	static Title title = new Title();
	
	public static List<String> msg = new ArrayList<>();
	
	public int count;
	
	public ActionBar(Player player) {
		count = -1;
		msg.add("§6§k!i§r §aBienvenue sur §d§lSyzonia §6§k!i");
		msg.add("§6dsc.gg/syzonia :3");
		msg.add("§aRank §3Legend §f» §d75euro à vie!");		
		msg.add("§eShop, Forum, News, Support, About §b§nhttps://syzonia.fr");
		msg.add("§eServeur Made In §bFr§fan§cce");
		msg.add("§9Nous recrutons §r--> §b§nhttps://jobs.syzonia.fr");
		msg.add("§bCopyright Lyxann Industries TTM");
	}
	
	public static void sendActionBar(Player player, String message) {
		title.sendActionBar(player, message);
	}
	
	public String NextMessage() {
		if(count < msg.size() - 1) {count++; } else { count = 0; }
		return msg.get(count);
	}
	
}
