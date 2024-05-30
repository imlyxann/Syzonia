package fr.syzonia.lydrageanas;

import java.io.File;


import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.lydrageanas.customevent.ServerAddEvent;
import fr.syzonia.lydrageanas.customevent.ServerRemoveEvent;
import fr.syzonia.lydrageanas.servers.ScannerRunnable;
import fr.syzonia.lydrageanas.servers.Server;
import fr.syzonia.lydrageanas.servers.ServerType;
import fr.syzonia.lydrageanas.servers.ServersCommon;
import fr.syzonia.lydrageanas.utils.ServerHelper;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin{

	public DatabaseManager database;
	public static Main INSTANCE;
	public HashMap<ServerType, String[]> path;
	public HashMap<String, Server> servers;
	
	@SuppressWarnings("serial")
	@Override
	public void onEnable() {
		INSTANCE = this;
		
		path = new HashMap<ServerType, String[]>()
				{{
					this.put(ServerType.LOBBY, new String[] { "C:/Users/Sacha/OneDrive/Documents/MC/Serveur/SyzoniaServLocal/Lobby%id%/".replace('/', File.separatorChar)});
					this.put(ServerType.CAKEWARS, new String[] { "C:/Users/Sacha/OneDrive/Documents/MC/Serveur/SyzoniaServLocal/CakeWars%id%/".replace('/', File.separatorChar)});
				}};
				
				
				servers = new HashMap<>();
				
			// initialisation des serveurs
				this.addServer(ServerType.LOBBY, "Lobby1", 31, "localhost");
				
		database = new DatabaseManager("jdbc:mysql://", "localhost", "syzonia_db", "root", "" );
		database.connexion();
		
		this.getProxy().getScheduler().schedule(INSTANCE, new ScannerRunnable(), 0, 8, TimeUnit.SECONDS);
		
		
	}
	
	@Override
	public void onDisable() {
		database.deconnexion();
	}
	
	public void addServer(ServerType type, String name, int port, String ip) {
		ServerInfo info = ProxyServer.getInstance().constructServerInfo(name, new InetSocketAddress(ip, port), "Lydrageanas System powered by Syzonia", false); 
		servers.put(name, new fr.syzonia.lydrageanas.servers.Server(type, new ServersCommon(name), info));
		addBungeeServer(name, InetSocketAddress.createUnresolved(ip, port));
    }
	
    public static void addBungeeServer(String name, InetSocketAddress inetSocketAddress) {
        ServerInfo info = ProxyServer.getInstance().constructServerInfo(name, inetSocketAddress, "Lydrageanas System powered by Syzonia", false);
        ServerAddEvent addEvent = new ServerAddEvent(info);
        ProxyServer.getInstance().getPluginManager().callEvent(addEvent);
        
        if (addEvent.isCancelled()) {
            return;
        }
        
        ServerHelper.addServer(addEvent.getServerModified());
    }
    public static void removeServer(String name, InetSocketAddress inetSocketAddress, Boolean fuck) {
        for (ProxiedPlayer p : ProxyServer.getInstance().getServerInfo(name).getPlayers()) {
            p.disconnect(new TextComponent("§cThis server was forcefully closed.\n§cPlease report this error in the bug report section of the forums."));
        }

        ServerInfo info = ProxyServer.getInstance().constructServerInfo(name, inetSocketAddress, "Lydrageanas System powered by Syzonia", false);
        ServerRemoveEvent event = new ServerRemoveEvent(info);
        ProxyServer.getInstance().getPluginManager().callEvent(event);
        
        if (event.isCancelled()) {
            return;
        }
        
        ServerHelper.removeServer(name);
    }
}
