package fr.syzonia.guilds.guild;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.bungeedb.mysql.guilds.GuildsManager;
import fr.syzonia.guilds.cmds.GuildCommands;
import fr.syzonia.guilds.utils.ConnectionUtils;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class GuildComponent {

	public GuildsManager guildsManager = new GuildsManager();
	
	public String getPlayerGuild(String player) {
		if(guildsManager.getAllGuilds() == null) return null;
			
			for(String guild : guildsManager.getAllGuilds()) {
				if(guildsManager.MemberIsInGuild(guild, player)) {
					return guild;
				}
			}
			return null;
	}
	
	public void sendMessageToAll(String guild, String msg) {
		for(String player : GuildsManager.getMembersList(guild)) {
			if(ConnectionUtils.getBungeeConnected(DatabaseManager.getUUID(player)) == true) {
				SendMessage(player, msg);
			}
		}
	}
	
	public void SendMessage(String player, String msg) {
		ProxiedPlayer pplayer = ProxyServer.getInstance().getPlayer(player);
		pplayer.sendMessage(new TextComponent(GuildCommands.PREFIX + " " + msg));
	}
	
}
