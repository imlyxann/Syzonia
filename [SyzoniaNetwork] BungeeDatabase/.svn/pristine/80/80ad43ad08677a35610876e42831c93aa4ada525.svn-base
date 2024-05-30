package fr.syzonia.bungeedb;

import java.awt.SystemColor;

import fr.syzonia.bungeedb.mysql.BanManager;
import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.bungeedb.mysql.MuteManager;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin 
{

	public static Main INSTANCE;
	public DatabaseManager database;
	public BanManager banManager = new BanManager();
	public MuteManager muteManager = new MuteManager();
	public String name, user, password, host;
	public int port;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		
		System.out.println(SystemColor.BLUE + "[BungeeBDD] Start...");
		database = new DatabaseManager("jdbc:mysql://", "localhost", "syzonia_db", "root", "");
		database.connexion();
		
	}
	
	@Override
	public void onDisable() {
		database.deconnexion();
		System.out.println(SystemColor.RED + "[BungeeBDD] Start...");
	}
	
	
}
