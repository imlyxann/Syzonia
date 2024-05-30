package fr.syzonia.syzowolfdb;

import org.bukkit.plugin.java.JavaPlugin;

import fr.syzonia.syzowolfdb.mysql.SyzoWolfDatabaseManager;

public class Main extends JavaPlugin{

	public static Main Instance;
	public SyzoWolfDatabaseManager database;
	
	@Override
	public void onLoad() { Instance = this; }
	
	@Override
	public void onEnable() {
		System.out.println("Syzowolf Db is loading...");
		
		// Action 
		
		database = new SyzoWolfDatabaseManager("jdbc:mysql://", "localhost", "syzowolf_db", "root", "");
		database.connexion();
		
		System.out.println("Syzowolf Db is starting!");
		
	}
	
	@Override
	public void onDisable() {
		
		// Stop Action
		
		System.out.println("Syzowolf Db is stopped!");
	}

}
