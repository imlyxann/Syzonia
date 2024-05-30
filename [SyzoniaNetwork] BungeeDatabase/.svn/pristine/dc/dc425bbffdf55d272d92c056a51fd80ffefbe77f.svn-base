package fr.syzonia.bungeedb.utils;

import java.util.UUID;


import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PlayerEnd {

	public static void disconnect(ProxiedPlayer player, TextComponent textComponent) {
    	if(player != null){
    		player.disconnect(new TextComponent(textComponent));
    	}
	}
	
	public static TextComponent banmsg(String reason, UUID uuid, String end) {
		return  new TextComponent("§r----- §6§lSyzonia §r- §cSanction §r-----\n " +
	 			"§7» §e§lVous avez été banni de Syzonia..." +
	 			"\n" +
                "\n§7Motif: §4" + reason +
                "\n§cCette penalité prend dans " + end +
                "\n " +
                "\n§bPour faire appel à cette sanction, rendez-vous sur le discord, merci." +
                "\nhttps://dsc.gg/syzonia" + 
                "\n§r---------------------------");
	}
	
}
