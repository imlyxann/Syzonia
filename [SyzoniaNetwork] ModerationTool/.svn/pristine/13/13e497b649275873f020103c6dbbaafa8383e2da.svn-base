package fr.syzonia.moderationtool.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.PlayerInfo;
import net.md_5.bungee.api.ChatColor;

public class VanishCommand implements CommandExecutor {

	public static List<String> VanishPlayers = new ArrayList<String>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;
		
		
		if(!(sender instanceof Player)) {
			return false;
		} else {
	
			if(args.length > 1) {
				DisplayHelp(player);
				return false;
			}
			
			if(new PlayerInfo(player.getUniqueId()).getRank() >= 5) {
				switch (args[0]) {
				case "list":
					
					 if (VanishPlayers.size() > 0) {
		                    StringBuilder builder = new StringBuilder();
		                    for (int i = 0; i < VanishPlayers.size(); i++) {
		                        builder.append(VanishPlayers.get(i));
		                        if (i < VanishPlayers.size() - 1) {
		                            builder.append(", ");
		                        }
		                    }
		                
		                    player.sendMessage(ChatColor.GRAY + "§dJoueurs Vanish: §a" + builder.toString());
					 } else {
						 player.sendMessage(ChatColor.GRAY + "§cIl n'y a pas de joueurs vanish.");
					 }
					
					break;

				case "me":
					
					if(!VanishPlayers.contains(player.getName())) {
						VanishPlayers.add(player.getName());
						for(Player others : Bukkit.getOnlinePlayers()) {
							others.hidePlayer(player);
						}
					   player.sendMessage("§aTu est invisible!");
					} else {
						VanishPlayers.remove(player.getName());
						for(Player others : Bukkit.getOnlinePlayers()) {
							others.showPlayer(player);
						}
					   player.sendMessage("§aTu est visible.");
					}
					
					break;
					
				case "check":
					
					if(args.length != 2) return false;
					
					String target = args[1];
					Player checker = Bukkit.getPlayer(target);
					
					if(checker != null && checker.isOnline()) {
						if(VanishPlayers.contains(checker.getName())) {
							player.sendMessage("§aLe joueur: §2" + target + " §aest Vanish");
						} else {
							player.sendMessage("§aLe joueur: §2" + target + " §an'est pas Vanish");
						}
					} else {
						player.sendMessage("§cJoueur Introuvable");
						return false;
					}
					
					break;

				case "target":
					if(args.length != 2) return false;
					
					String target1 = args[1];
					Player playertarget = Bukkit.getPlayer(target1);
					
					if(playertarget != null) {
						if(VanishPlayers.contains(target1)) {
							VanishPlayers.remove(target1);
							for(Player others : Bukkit.getOnlinePlayers()) {
								others.showPlayer(playertarget);
							}
						   player.sendMessage("§2" + target1 +" §aest visible!");
						} else {
							VanishPlayers.add(target1);
							for(Player others : Bukkit.getOnlinePlayers()) {
								others.hidePlayer(playertarget);
							}
						   player.sendMessage("§2" + target1 +" §aest invisible!");
						}
					} else {
						player.sendMessage("§cJoueur Introuvable");
						return false;
					}

					break;
					
				default:
					break;
				}
			}
		}
		
		return true;
	}
	
	public void DisplayHelp(Player player) {
		player.sendMessage("\n");
		player.sendMessage("§l§cSystème Vanish");
		player.sendMessage(" §2» §a/Vanish <list>");
		player.sendMessage(" §2» §a/Vanish <me>");
		player.sendMessage(" §2» §a/Vanish <check>");
		player.sendMessage(" §2» §a/Vanish <target>");
		player.sendMessage("\n");
	}

}
