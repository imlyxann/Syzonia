package fr.syzonia.syzodb;


import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;

import fr.syzonia.syzodb.Lydrageanas.LydraCommand;
import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.server.Servers;
	
	
public class Main extends JavaPlugin{
	
	
	public static Main Instance;
	public Servers serverCommon;
	public static MySql database;
	public String name, user, password, host;
	public int port;
	
	@Override
	public void onEnable() {
		Instance = this;
		System.out.println("[Database] Loading.");
		
		database = new MySql("jdbc:mysql://", "localhost", "syzonia_db", "root", "");
		database.connexion();
		
		serverCommon = new Servers(Bukkit.getServerName());
		serverCommon.loadServer(Bukkit.getIp(), Bukkit.getPort(), "");
		serverCommon.setStatus(1);

		new LydraCommand().runTaskTimer(Instance, 0L, 1L);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[Database] Stop");
		
		if(serverCommon.getStatus() == 2) {
			serverCommon.setStatus(2);
			return;
		}
		
		
		serverCommon.setStatus(0);
		database.deconnexion();
	}
	
	public static Main getInstance() {
		return Instance;
	}
	
}
