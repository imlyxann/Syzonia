package fr.syzonia.syzobungee;

import fr.syzonia.syzobungee.commands.BroadCastCommand;
import fr.syzonia.syzobungee.commands.FriendsCommand;
import fr.syzonia.syzobungee.commands.HubCommand;
import fr.syzonia.syzobungee.commands.MaintenanceCmd;
import fr.syzonia.syzobungee.commands.MoveCommand;
import fr.syzonia.syzobungee.commands.MuteCommand;
import fr.syzonia.syzobungee.commands.TestCommand;
import fr.syzonia.syzobungee.commands.UnMuteCommand;
import fr.syzonia.syzobungee.listeners.AsyncChatListener;
import fr.syzonia.syzobungee.listeners.ChanneListener;
import fr.syzonia.syzobungee.listeners.PreloginListener;
import fr.syzonia.syzobungee.listeners.ProxiedPlayerJoinListener;
import fr.syzonia.syzobungee.listeners.ProxiedPlayerQuitListener;
import fr.syzonia.syzobungee.listeners.ServerConnectListener;
import fr.syzonia.syzobungee.listeners.ServerListener;
import fr.syzonia.syzobungee.listeners.ServerPingListener;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;


public class Main extends Plugin{

	public static Main Instance;
	public static int Maintenance = 0;
	public static boolean soon = true;
	public static boolean HubForcedConnected;
	
	@Override
	public void onEnable() {
		Instance = this;
		HubForcedConnected = true;
		Maintenance = 0;
		
		System.out.println("§d[ProyCore] Start");
		
		ProxyServer.getInstance().getPluginManager().registerListener(this, new ProxiedPlayerJoinListener());
		ProxyServer.getInstance().getPluginManager().registerListener(this, new ProxiedPlayerQuitListener());
		ProxyServer.getInstance().getPluginManager().registerListener(this, new AsyncChatListener());
		ProxyServer.getInstance().getPluginManager().registerListener(this, new ChanneListener());
		ProxyServer.getInstance().getPluginManager().registerListener(this, new ServerPingListener());
		ProxyServer.getInstance().getPluginManager().registerListener(this, new ServerConnectListener());
		ProxyServer.getInstance().getPluginManager().registerListener(this, new PreloginListener());
		ProxyServer.getInstance().getPluginManager().registerListener(this, new ServerListener());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new FriendsCommand());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new MuteCommand());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new UnMuteCommand());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new MaintenanceCmd());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new BroadCastCommand());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new TestCommand());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new HubCommand());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new MoveCommand());
	}
	
	@Override
	public void onDisable() {
		System.out.println("§c[ProyCore] Stop");
	}
	
	
	
}
