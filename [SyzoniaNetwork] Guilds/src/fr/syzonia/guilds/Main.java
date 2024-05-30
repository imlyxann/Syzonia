package fr.syzonia.guilds;

import fr.syzonia.guilds.cmds.GuildCommands;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin{

	public static Main Instance;
	
	@Override
	public void onLoad() { Instance = this; }
	
	@Override
	public void onEnable() { 
		ProxyServer.getInstance().getPluginManager().registerCommand(Instance, new GuildCommands());
	}
	
	@Override
	public void onDisable() {
	}
	
}
