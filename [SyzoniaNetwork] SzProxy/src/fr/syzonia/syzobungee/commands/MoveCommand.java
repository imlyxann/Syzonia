package fr.syzonia.syzobungee.commands;

import java.net.InetSocketAddress;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.syzobungee.server.ServerComponent;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MoveCommand extends Command {

	public MoveCommand() {
		super("move");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(!(sender instanceof ProxiedPlayer)) {
			String playername = args[0];
			String servername = args[1];
			ProxiedPlayer player = ProxyServer.getInstance().getPlayer(playername);
			
			if(player == null) {
				return;
			}
			
			ProxyServer.getInstance().broadcast(new TextComponent(new TextComponent("§6" + playername + " is sent to " + servername)));
			
			ServerInfo info = ProxyServer.getInstance().constructServerInfo(servername, new InetSocketAddress(ServerComponent.getAdress(servername), ServerComponent.getPort(servername)), "Lydrageanas System powered by Syzonia", false); 
			player.connect(info);
		} else {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			if(DatabaseManager.getPlayerRank(player.getUniqueId()) == 7) {
				String playername = args[0];
				String servername = args[1];
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(playername);
				
				if(target == null) {
					return;
				}
				
				ProxyServer.getInstance().broadcast(new TextComponent(new TextComponent("§6" + playername + " is sent to " + servername + " by " + player.getName())));
				
				ServerInfo info = ProxyServer.getInstance().constructServerInfo(servername, new InetSocketAddress(ServerComponent.getAdress(servername), ServerComponent.getPort(servername)), "Lydrageanas System powered by Syzonia", false); 
				target.connect(info);
			}
		}
		
		
	}

}
