package fr.syzonia.syzobungee.listeners;


import com.google.common.io.ByteArrayDataInput;

import com.google.common.io.ByteStreams;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChanneListener implements Listener {

	@EventHandler
	public void Messaging(PluginMessageEvent event) {
		if(!event.getTag().equals("BungeeCord")) return;
		
		ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
		
		String cache = in.readUTF();
	
		if(cache.equalsIgnoreCase("banmod")) {
			String target = in.readUTF();
			String reason = in.readUTF();
			
			for(ProxiedPlayer staff : ProxyServer.getInstance().getPlayers()) {
				if(DatabaseManager.getPlayerRank(staff.getUniqueId()) >= 5) {
					staff.sendMessage(new TextComponent("§7[§7Ban§7] §aLe joueur: §6" + target + " §aest ban pour la raison: §c" + reason));
				}
			}
		}
		
		if(cache.equalsIgnoreCase("banplayer")) {
			String target = in.readUTF();
			String reason = in.readUTF();
			
			ProxiedPlayer player = ProxyServer.getInstance().getPlayer(target);
			if(player != null) {
				player.disconnect(new TextComponent(reason));
			}
		}
			if(cache.equalsIgnoreCase("syzowolfalert")) {
				String target = in.readUTF();
				String reason = in.readUTF();
				String TAG = in.readUTF();
				
				for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
					players.sendMessage(new TextComponent(TAG + "Le joueur " + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + target + ChatColor.DARK_PURPLE + ChatColor.BOLD + " §da §dété §dbanni §dpour §dla §draison " + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + reason + ChatColor.DARK_PURPLE + ChatColor.BOLD + "."));
				}
		}
			
			if(cache.equalsIgnoreCase("syzowolfflag")) {
				String msg = in.readUTF();
				
				for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
					if(DatabaseManager.getPlayerRank(players.getUniqueId()) >= 5) {
						players.sendMessage(new TextComponent(msg));
					}
				
			}
		}
	}
	
}