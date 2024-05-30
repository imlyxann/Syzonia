
package fr.syzonia.hub.commands.staff;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.rank.Syzorank;


public class CoinsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)){
			return true;
		}
		
		Player player = (Player) sender;
		PlayerInfo plInfo = PlayerInfo.getInfos(player.getUniqueId());
		
		if (plInfo.getRank() != -1) {
			if (args.length == 0) {
				player.sendMessage("§6[§bSyzocoins§6]" + " §5Vous avez actuellement: " + plInfo.getCoinsNumber() + " coins!");
				return true;
			}
		}
		if(plInfo.getRank() >= 5) {		
		
			if (args.length >= 1 ) {
				if(args[0].equalsIgnoreCase("add")) {
					if(args.length == 3) {
						UUID target = MySql.getUUID(args[1]); 
						if(target == null) {
							player.sendMessage("§cJoueur inconnu ou introuvable");
							return false;
						}
						
						int amount = Integer.valueOf(args[2]);
						PlayerInfo targetInfo = new PlayerInfo(target);
						targetInfo.addCoins(amount);
						player.sendMessage(new Syzorank(targetInfo.getRank()).getDisplayName(target) + " " + args[1] + " §6a reçu " + amount + " §dSyzoCoins!");
					}
				} else if(args[0].equalsIgnoreCase("remove")) {
					if(args.length == 3) {
							UUID target = MySql.getUUID(args[1]); 
							if(target == null) {
								player.sendMessage("§cJoueur inconnu ou introuvable");
								return false;
							}
							
							int amount = Integer.valueOf(args[2]);
							PlayerInfo targetInfo = new PlayerInfo(target);
							targetInfo.removeCoins(amount);
							player.sendMessage(new Syzorank(targetInfo.getRank()).getDisplayName(target) + " " + args[1] + " §6a perdu " + amount + " §dSyzoCoins...");
					}
				}
			}
		}
		
		if(plInfo.getRank() < 5) {
			player.sendMessage("§4Vous n'avez pas le droit d'utiliser cette commande");
			return true;
		}
			

		
		return true;
	}
	
	
}
