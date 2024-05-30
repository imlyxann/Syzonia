package fr.syzonia.hub;

import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Difficulty;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import fr.syzonia.core.armorstand.ArmorStandManager;
import fr.syzonia.core.npc.NpcManager;
import fr.syzonia.hub.Mount.type.CustomEntityType;
import fr.syzonia.hub.armorstands.ArmorStands;
import fr.syzonia.hub.commands.CommandManager;
import fr.syzonia.hub.listeners.ListenerManager;
import fr.syzonia.hub.packet.PacketReader;
import fr.syzonia.hub.runnable.divers.MessageRunnable;
import fr.syzonia.syzodb.hub.DatabaseConnect;
import fr.syzonia.syzodb.mysql.hub.HubManager;

public class Hub extends JavaPlugin{

	
	public static Hub Instance;
	public DatabaseConnect database;
	
 	public static boolean isFake;
	
 	 public static PacketReader reader;
 	
 	// Sys color
 	 
     // Reset
     public static final String RESET = "\033[0m";  // Text Reset

     // Regular Colors
     public static final String BLACK = "\033[0;30m";   // BLACK
     public static final String RED = "\033[0;31m";     // RED
     public static final String GREEN = "\033[0;32m";   // GREEN
     public static final String YELLOW = "\033[0;33m";  // YELLOW
     public static final String BLUE = "\033[0;34m";    // BLUE
     public static final String PURPLE = "\033[0;35m";  // PURPLE
     public static final String CYAN = "\033[0;36m";    // CYAN
     public static final String WHITE = "\033[0;37m";   // WHITE

     // Bold
     public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
     public static final String RED_BOLD = "\033[1;31m";    // RED
     public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
     public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
     public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
     public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
     public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
     public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

     // Underline
     public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
     public static final String RED_UNDERLINED = "\033[4;31m";    // RED
     public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
     public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
     public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
     public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
     public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
     public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
 	 
     BukkitTask HubTask;
     BukkitTask HubPlayerTask;
     
     public static final FireworkEffect FIREWORK = FireworkEffect.builder().with(FireworkEffect.Type.STAR).withColor(Color.GRAY, Color.ORANGE, Color.WHITE).withFade(Color.YELLOW).withTrail().withFlicker().build();
     
	@Override
	public void onEnable() {
		Instance = this;
		CustomEntityType.registerAllEntities();
		
		
		if(Bukkit.getIp().contains("localhost")) isFake = true;
		
		// Une petite connexion :D
		database = new DatabaseConnect("jdbc:mysql://", "localhost", "syzonia_db", "root", "");
		database.connexion();	
		
		// on register les listeners :3
		new ListenerManager(this).registerListeners();
		
		if(isFake) {
			Hub.Log(GREEN + "Le serveur tourne en localhost." + RESET);
			Hub.LogWarn(RED_BOLD + "Merci de ne pas rajouter ce serveur dans la Base de donnees de syzonia" + RESET);
		}
		
        for (Player player : Bukkit.getOnlinePlayers()) {
        	reader = new PacketReader(player);
            reader.inject();
        }
		
		new CommandManager().registerCmds(Instance);
        
    	NpcManager.spawnNpc(new Location(Bukkit.getWorld("world"), 13.431, 92, 9.489), 1, 1, "§cCake§bwars", "ManlyPotato", 122);
    	// NpcManager.spawnNpc(new Location(Bukkit.getWorld("world"), 0, 0, 0), 2, 2, "§4Loup-Garou", "WereWolf", 0);
    	
    	ItemStack[] items = {null, null, null, null, null};
    	new ArmorStandManager();
		ArmorStandManager.createArmorStand(1, "§b\\o/ §f« §l§dLootbox §f» §b\\o/", true, new Location(Bukkit.getWorld("world"), -10.035, 93.5, -10.024, -40, -29), false, false, false, items);
    	ArmorStands.spawnFlossArmor();
		
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		
		new MessageRunnable().runTaskTimer(this, 0L, 20L);
		
		new HubManager().addHub(Bukkit.getServerName(), Bukkit.getIp(), Bukkit.getPort(), Bukkit.getOnlinePlayers().size());
		
		HubRunnable();
		HubPlayerRunnable();
		
		Bukkit.getWorld("world").setPVP(false);
		Bukkit.getWorld("world").setStorm(false);
		Bukkit.getWorld("world").setTime(1000);
		Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
		Bukkit.getWorld("world").setGameRuleValue("doDaylightCycle", "false");
		Bukkit.getWorld("world").setGameRuleValue("doMobSpawning", "false");

	}
	
	@Override
	public void onDisable() {

		new HubManager().removeHub(Bukkit.getServerName());

		for (Player player : Bukkit.getOnlinePlayers()) {		
			reader = new PacketReader(player);
            reader.uninject();          
        }
		
		NpcManager.removeAll();
		ArmorStandManager.ArmorStands.get(1).remove();
		ArmorStandManager.ArmorStands.remove(1);
		ArmorStands.removeFlossArmor();
		
		database.deconnexion();

	}
	
	
	
	public void HubRunnable() {
		if(HubTask == null) {	
			BukkitTask task = Bukkit.getScheduler().runTaskTimer(Instance, new Runnable() {
				
				@Override
				public void run() {
					

					Bukkit.getWorld("world").setPVP(false);
					Bukkit.getWorld("world").setStorm(false);
					Bukkit.getWorld("world").setTime(1000);
					Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
					Bukkit.getWorld("world").setGameRuleValue("doDaylightCycle", "false");
					Bukkit.getWorld("world").setGameRuleValue("doMobSpawning", "false");

				}
			}, 0, 1L);
			
			HubTask = task;
		}

		if(!isEnabled()) {
			HubTask.cancel();
		}
			
	}
	
	public void HubPlayerRunnable() {
		if(HubPlayerTask == null) {	
			BukkitTask task = Bukkit.getScheduler().runTaskTimer(Instance, new Runnable() {
				
				@Override
				public void run() {

					new HubManager().setHubPlayers(Bukkit.getServerName(), Bukkit.getOnlinePlayers().size());
					
				}
			}, 0, 20L);
			
			HubPlayerTask = task;
		}

		if(!isEnabled()) {
			HubPlayerTask.cancel();
		}
			
	}

	public static Hub getInstance() {
		return Instance;
	}
	
	
	public static void Log(Object obj) {
		getInstance().getLogger().log(Level.INFO, obj.toString());
	}
	
	public static void LogErr(Object obj) {
		getInstance().getLogger().log(Level.SEVERE, obj.toString());
	}
	
	public static void LogWarn(Object obj) {
		getInstance().getLogger().log(Level.WARNING, obj.toString());
	}
	
}
