package fr.syzonia.hub.listeners.gameplay;

import org.bukkit.Bukkit;



import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.syzonia.syzodb.mysql.MessageInfo;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.rank.Syzorank;
import fr.syzonia.syzodb.token.TokenManager;
import fr.syzonia.hub.commands.staff.ShutUpCommand;


public class PlayerChatListener implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		PlayerInfo playerinfo = new PlayerInfo(player.getUniqueId());
		
		event.setCancelled(true);
		
		if(event.getMessage() != null) {
			if(ShutUpCommand.ShutUp) {
				player.sendMessage("§cLe Chat est bouclé par un membre du staff (Les commands, Msg, Partys ne seront pas afféctés).");
				return;
			}
			
			if(new TokenManager().TokenIsCreate(player.getUniqueId())) {
				if(event.getMessage().contains(new TokenManager().getToken(player.getUniqueId()))) {
					player.sendMessage("§cVous avez failli leak votre token mais heureusement qu'il y a une sécurité!");
					return;
				}
			}
			
			event.setFormat(new Syzorank(playerinfo.getRank()).getDisplayName(player.getUniqueId())  + " " + player.getName() + "§7 > §f" + event.getMessage());

			for (Player players : Bukkit.getOnlinePlayers()) {
				players.sendMessage(event.getFormat());
			}
			
			MessageInfo messageInfo = new MessageInfo(player);
			messageInfo.setLastMessage(event.getMessage());
			
		}
	}
}
