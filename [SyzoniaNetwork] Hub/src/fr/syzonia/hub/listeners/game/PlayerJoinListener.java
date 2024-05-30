package fr.syzonia.hub.listeners.game;

import org.bukkit.Bukkit;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import fr.syzonia.core.firework.FireWorkUtils;
import fr.syzonia.core.npc.NpcManager;
import fr.syzonia.core.tablist.TeamsTagManager;
import fr.syzonia.core.title.Title;
import fr.syzonia.syzodb.Main;
import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.mysql.OpManager;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.mysql.friends.FriendBDD;
import fr.syzonia.syzodb.rank.Rank;
import fr.syzonia.syzodb.rank.Syzorank;
import fr.syzonia.syzodb.server.Servers;
import fr.syzonia.hub.Hub;
import fr.syzonia.hub.VirtualMenu.Friends.VirtualFriends;
import fr.syzonia.hub.finezherbe.FineZherbeUtils;
import fr.syzonia.hub.item.ItemBuilder;
import fr.syzonia.hub.packet.PacketReader;
import fr.syzonia.hub.player.SyzoniaPlayer;
import fr.syzonia.hub.rewards.RewarsSystem;
import fr.syzonia.hub.runnable.ActionBarRunnable;
import fr.syzonia.hub.runnable.MainRunnable;
import fr.syzonia.hub.runnable.ScoreboardLoadRunnable;
import fr.syzonia.hub.runnable.queue.QueueRunnable;
import fr.syzonia.hub.scoreboard.ScoreboardAnimation;

public class PlayerJoinListener implements Listener {
	
	public static Title title = new Title();
	
	@EventHandler(priority = EventPriority.HIGH)
	public void PlayerJoin(PlayerJoinEvent event) {	
			Player player = event.getPlayer();

			if(Main.database.isBanned(player.getUniqueId())) {
				event.setJoinMessage(null);
				return;
			}

			Main.database.createAccount(player.getUniqueId());
			PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
			Servers.addPlayer(player.getName(), Bukkit.getServerName());
			
			SyzoniaPlayer syzoPlayer = new SyzoniaPlayer(player.getName());
			syzoPlayer.scoreboard.loadScoreboard();
			
			player.sendMessage("§aSalut §b" + player.getName() + " §aet bienvenue sur Syzonia !");
			event.setJoinMessage(new Syzorank(playerinfo.getRank()).getDisplayName(player.getUniqueId()) + " " + event.getPlayer().getName() + " §6§oa rejoint le Hub!");
			player.playSound(player.getEyeLocation(), Sound.LEVEL_UP, 1f, 15f);
			player.getInventory().clear();
			
			if(playerinfo.getRank() == 7) {
				player.setOp(true);
				player.setAllowFlight(true);
			} else if(playerinfo.getRank() > 0 ) {
				player.setOp(false);
				player.setAllowFlight(true);
			} else if(playerinfo.getRank() == 0) {
				player.setOp(false);
				player.setAllowFlight(false);
			}
			
				
			System.out.println("Login [" + player.getName() + "] with uuid: " + player.getUniqueId() +" to the server!");

			Main.database.setPseudo(player.getUniqueId(), player.getName());	
			TeamsTagManager.setNameTag(player, Rank.PowerToRank(playerinfo.getRank()).getOrderRank(), new Syzorank(playerinfo.getRank()).getDisplayName(player.getUniqueId()) + " ", "");

			player.setTotalExperience(0);
			player.setExp(0);
			
	        PacketReader reader = new PacketReader(player);
	        try{
	        	reader.inject();
	        } catch (Exception e){
	            System.out.println("Player not injected!!!!!!");
	        }
	        
	        NpcManager.addJoinPacket(player);
			
	
			player.setNoDamageTicks(100000);
			player.setGameMode(GameMode.ADVENTURE);
			player.setFoodLevel(20);
			player.setHealth(20);
			
			OpManager opplayer = new OpManager();
			opplayer.createOPAccount(player.getUniqueId());
			if(player.isOp()) {
				opplayer.setop(player, 1);
			} else {
				opplayer.setop(player, 0);
			}

			player.getActivePotionEffects().removeAll(player.getActivePotionEffects());
			
			Location loc = new Location(Bukkit.getWorld("world"), player.getWorld().getSpawnLocation().getX(), player.getWorld().getSpawnLocation().getY(), player.getWorld().getSpawnLocation().getZ());
			player.teleport(loc);
			
			FineZherbeUtils.Appliquer(player);
			
			new RewarsSystem().load(player);
			
			title.sendFullTitle(player, 10, 30, 10, "§6§o§lSyzonia", "§eBienvenue " + new Syzorank(playerinfo.getRank()).getDisplayName(player.getUniqueId()) + " " + event.getPlayer().getName());
				        
		    FireWorkUtils.launchfw(player.getEyeLocation(), Hub.FIREWORK);
			
			player.getInventory().setItem(0, new ItemBuilder().type(Material.COMPASS).name("§6Menu Principal").lore("§7Permet d'accéder au menu principal").build());
			player.getInventory().setItem(1, new ItemBuilder().type(Material.SKULL_ITEM).data((byte) 3).name("§6Profil").lore("§7Permet d'accéder à votre Profil.").setSkullOwner(player.getName()).build());
			player.getInventory().setItem(7, new ItemBuilder().type(Material.NETHER_STAR).name("§dShop").lore("§dPermet d'accéder à la boutique").build());
			player.getInventory().setItem(8, new ItemBuilder().type(Material.COOKIE).name("§bTéléportation").lore("§bPermet d'accéder au menu des téléportations").build());
			
			
			  new MainRunnable(player).run();
		      new ScoreboardLoadRunnable(player).run();
			  new ActionBarRunnable(player).run();
			  new QueueRunnable(player).runTaskTimer(Hub.getInstance(), 0L, 1L);
			  new ScoreboardAnimation(player).runTaskTimer(Hub.Instance, 0L, 1L);
			  
				int friendsonline = 0;
				int friendcounter = 0;
				
				FriendBDD friendbdd = new FriendBDD();
				
				friendcounter = friendbdd.getFriendsCounter(player.getName());
					
					for(String friends : friendbdd.getFriendList(player.getName())) {
						boolean friendonline = new VirtualFriends().getBungeeConnected(MySql.getUUID(friends));
						if(friendonline == true) {
							friendsonline++;
						}
					}
					
				player.sendMessage("§6--------------------------------------------------");
				player.sendMessage("§eAmi en ligne §a" + friendsonline + "§r/§b" + friendcounter);
				player.sendMessage("§6--------------------------------------------------");
				
	}
	
}
