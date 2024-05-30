package fr.syzonia.hub.commands.staff;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.rank.Rank;
import fr.syzonia.syzodb.rank.TeamsManager;

public class RankCommand implements CommandExecutor {

	public UUID uuid;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		PlayerInfo plinfo = PlayerInfo.getInfos(player.getUniqueId());
		
		if(!(sender instanceof Player)) {
			return true;
		}
			if(plinfo.getRank() >= 5) {
				if (args.length >= 1) {
					UUID target = MySql.getUUID(args[0]);
					if(target == null) {
						player.sendMessage("§cJoueur inconnu ou introuvable");
						return false;
					}
					
					int power = Integer.valueOf(args[1]);
					if( !(power >= 0) || !(power <= 7)) {
						player.sendMessage("§cGrade Inconnu");
						return false;
					}
					TeamsManager.Syzorank(target, power);
					player.sendMessage("§r[§bGrade§r]" + " §bLe joueur: §4 " + args[0] + " §best maintenant " + Rank.getPowerRank(power).getName());
				}
			} 			
			return true;
		
	}

}

