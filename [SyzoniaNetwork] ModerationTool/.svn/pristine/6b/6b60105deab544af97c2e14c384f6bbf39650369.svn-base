package fr.syzonia.moderationtool.cmds;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.core.title.Title;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.moderationtool.Main;

public class FreezeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;
		
		if(!(sender instanceof Player)) {
			return false;
		} else {
			
			if(PlayerInfo.getInfos(player.getUniqueId()).getRank() >= 5) {
				
				if(args.length != 1) {
					player.sendMessage("§cIl faut faire la commande: /freeze <player>");
					return false;
				}
				
				String targetName = args[0];
				Player targetPlayer = Bukkit.getPlayer(targetName);
				
				if(targetPlayer == null) {
					player.sendMessage("§cLe(a) joueur(se) est inconnu(e) ou Hors-Ligne!");
				}
				if(!Main.PlayerFreeze.contains(targetName)) {
					Main.PlayerFreeze.add(targetName);
					new Title().sendFullTitle(targetPlayer, 10, 30, 10, "§bFreeze", "§4Si tu quittes, c'est un ban!");
					targetPlayer.sendMessage("§7[§bFreeze§7] §4Tu as été Freeze par §c" + player.getDisplayName());
				} else {
					player.sendMessage("§cCe joueur est déjà freeze");
				}
			}
		}
		
		return true;
	}

}
