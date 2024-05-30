package fr.syzonia.cakewars;

import java.util.ArrayList;




import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import fr.syzonia.cakewars.commands.GameCommand;
import fr.syzonia.cakewars.region.RegionManager;
import fr.syzonia.syzodb.game.ServerGameStatus;
import fr.syzonia.syzodb.mysql.game.CakeWarsGameManager;
import fr.syzonia.syzodb.utils.ServerType;


public class Main extends JavaPlugin{

	public static Main Instance;
	
	public RegionManager redBase, blueBase, yellowBase, whiteBase, pinkBase, cyanBase, greenBase, grayBase;
	
	public List<UUID> PlayerDidntHaveRole = new ArrayList<>();
	public List<UUID> red_team = new ArrayList<>();
	public List<UUID> blue_team = new ArrayList<>();
	public List<UUID> yellow_team = new ArrayList<>();
	public List<UUID> white_team = new ArrayList<>();
	public List<UUID> pink_team = new ArrayList<>();
	public List<UUID> cyan_team = new ArrayList<>();
	public List<UUID> green_team = new ArrayList<>();
	public List<UUID> gray_team = new ArrayList<>();
	
	public World world = Bukkit.getWorld("world");
	
	@Override
	public void onLoad() { Instance = this; }
	
	@Override
	public void onEnable() {
		if(Bukkit.getServerName().contains("cksp")) {
			
			System.out.println("[CakeWars] Starting..");
			
			
			redBase = new RegionManager(new Location(world, -42, 63, -64), new Location(world, -20, 63, -91));
			blueBase = new RegionManager(new Location(world, 22, 63, -65), new Location(world, 44, 63, -90));
			yellowBase = new RegionManager(new Location(world, 63, 63, 22), new Location(world, 90, 63, 43));
			whiteBase = new RegionManager(new Location(world, -22, 63, 63), new Location(world, -44, 63, 91));
			pinkBase = new RegionManager(new Location(world, -63, 63, 43), new Location(world, -91, 63, 21));
			cyanBase = new RegionManager(new Location(world, 41, 64, 65), new Location(world, 22, 64, 91));
			greenBase = new RegionManager(new Location(world, 64, 63, -42), new Location(world, 89, 63, -19));
			grayBase = new RegionManager(new Location(world, -65, 63, -21), new Location(world, -91, 63, -44));
					
			
			this.getCommand("game").setExecutor(new GameCommand());
			
			RegisterCakeWarsServer("Cakewars", Bukkit.getServerName(), "SOLO", Bukkit.getIp(), Bukkit.getPort(), "Test", 0, ServerGameStatus.LIGNE.toString(), Bukkit.getMaxPlayers());
			
		} else if(Bukkit.getServerName().contains("ckdp")) {
			
		} else {
			Bukkit.shutdown();
		}
	}
	
	@Override
	public void onDisable() {
		System.out.println("[CakeWars] Stopping");
	
		
		UnRegisterCakeWarsServer("Cakewars", Bukkit.getServerName(), ServerType.CAKEWARS.toString(), Bukkit.getIp(), Bukkit.getPort(), "Test", 0, ServerGameStatus.LIGNE.toString(), Bukkit.getMaxPlayers());
	}
	
	public static Main getInstance() {
		return Instance;
	}
	
	public static String getPrefix(int Prefix_Number) {
		if(Prefix_Number == 1) {
			return "§7[§eCK§7]";
		}
		
		if(Prefix_Number == 2) {
			return "§7[§aInfo§7]";
		}
		
		if(Prefix_Number == 3) {
			return "§7[§4Alert§7]";
		}
		
		return null;
	}
	
	public void RegisterCakeWarsServer(String gamename, String servername, String type, String ip, int port, String Map, int maintenance, String status, int Max_player) {
		new CakeWarsGameManager().registerGame(servername, status, port, Map, Max_player, ip, maintenance, type);
	}
	
	public void UnRegisterCakeWarsServer(String gamename, String servername, String type, String ip, int port, String Map, int maintenance, String status, int Max_player) {
		new CakeWarsGameManager().DelGame(servername);
	}
	
}
