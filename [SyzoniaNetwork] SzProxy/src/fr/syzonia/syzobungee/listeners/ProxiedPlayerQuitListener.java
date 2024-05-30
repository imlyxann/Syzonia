package fr.syzonia.syzobungee.listeners;

import fr.syzonia.bungeedb.Main;
import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.bungeedb.mysql.FriendBDD;
import fr.syzonia.syzobungee.PlayerConnections;
import fr.syzonia.syzobungee.player.ServerName;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxiedPlayerQuitListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void PlayerQuit(PlayerDisconnectEvent event) {
		
		ProxiedPlayer p = event.getPlayer();
		
		if(Main.INSTANCE.banManager.isBanned(p.getUniqueId())) {
			return;
		}
		
		new PlayerConnections().setBungeeConnected(p.getUniqueId(), false);
		ServerName.setServerName(p.getUniqueId(), null);
		
		if(DatabaseManager.getUUID(p.getName()) != null) {
			for(ProxiedPlayer playerOnline : ProxyServer.getInstance().getPlayers()) {
				if(new FriendBDD().isFriendWith(p.getName(), playerOnline.getName())) {
					if(!playerOnline.getName().equalsIgnoreCase(p.getName())) {
						playerOnline.sendMessage("§r[§dAmis§r] §b" + p.getName() + " §avient de se déconnecter..");
					}
				}
			}
		}
	}
	

	
}
