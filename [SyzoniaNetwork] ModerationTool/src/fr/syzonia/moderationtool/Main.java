package fr.syzonia.moderationtool;

import java.util.ArrayList;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.syzonia.moderationtool.cmds.BanCommand;
import fr.syzonia.moderationtool.cmds.FreezeCommand;
import fr.syzonia.moderationtool.cmds.ReportCommand;
import fr.syzonia.moderationtool.cmds.UnBanCommand;
import fr.syzonia.moderationtool.cmds.UnFreezeCommand;
import fr.syzonia.moderationtool.cmds.VanishCommand;
import fr.syzonia.moderationtool.listeners.PlayerListener;
import fr.syzonia.moderationtool.sanctions.Sanction;

public class Main extends JavaPlugin{
	
	public static List<String> PlayerFreeze = new ArrayList<String>();
	
	public static Main Instance;
	@Override
	public void onEnable() {
	
		Instance = this;
		
		getCommand("unban").setExecutor(new UnBanCommand());
		getCommand("freeze").setExecutor(new FreezeCommand());
		getCommand("unfreeze").setExecutor(new UnFreezeCommand());
		getCommand("unfreeze").setExecutor(new UnFreezeCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("ss").setExecutor(new Sanction());
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerListener(), Instance);
		pm.registerEvents(new ReportCommand(), Instance);
		pm.registerEvents(new Sanction(), Instance);
		
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
	
	@Override
	public void onDisable() {

		
		
	}

}
