package fr.syzonia.syzobungee.commands;

import java.net.InetSocketAddress;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.syzobungee.server.MiniServer;
import fr.syzonia.syzobungee.server.ServerComponent;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServerCommand extends Command {

	public ServerCommand() {
		super("server");
	}

	@Override
	public void execute(CommandSender arg0, String[] arg1) {

		if(DatabaseManager.getPlayerRank(ProxyServer.getInstance().getPlayer(arg0.getName()).getUniqueId()) == 7) {
			if(arg1.length != 0) {
				ProxiedPlayer player = (ProxiedPlayer) arg0;
				ServerInfo info = ProxyServer.getInstance().constructServerInfo(arg1[arg1.length - 1], new InetSocketAddress(ServerComponent.getAdress(arg1[arg1.length - 1]), ServerComponent.getPort(arg1[arg1.length - 1])), "Lydrageanas Powered by Syzonia", false);
				player.connect(info);
				return;
			}
			
			List<MiniServer> servers = new ArrayList<MiniServer>();
			TextComponent serverText = new TextComponent();
			
			try {
				PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("SELECT * FROM servers WHERE 1");
				try(ResultSet set = stat.executeQuery()) {
					while(set.next()) {
						if(set.getString("server_name").startsWith("Lobby")) {
							servers.add(new MiniServer(set.getString("server_name"), set.getInt("port"), set.getString("ip"), "Lobby"));
						} else if(set.getString("server_name").startsWith("ck")) {
							servers.add(new MiniServer(set.getString("server_name"), set.getInt("port"), set.getString("ip"), "CakeWars"));
						}
					}
				}
				stat.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			if(servers.isEmpty()) return;
			
			
			serverText.setText("§eTous les Serveurs de Syzonia disponibles: \n");
			
			int count = 0;
			
	        for (MiniServer server : servers) {
	            String serverName = server.getName();
	            String serverInfo = "§eInfos du serveur: " + server.getName() + "\n\n§6Ip: " + server.getIp() + "\n§6Port: " + server.getPort() + "\n§6Type: " + server.getType();

	            TextComponent serverComponent = new TextComponent(serverName);
	            serverComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(serverInfo + "\n§dLydrageanas Powered by Syzonia")));
	            if(!(count + 1 == servers.size())) serverComponent.addExtra(", ");  
	            serverComponent.setColor(ChatColor.GREEN);
	            ClickEvent cevent = new ClickEvent(Action.RUN_COMMAND, "/server " + serverName);
	            serverComponent.setClickEvent(cevent);
	            
	            serverText.addExtra(serverComponent);
	            
	            count++;
	        }

	        arg0.sendMessage(serverText);
		}
	}

}
