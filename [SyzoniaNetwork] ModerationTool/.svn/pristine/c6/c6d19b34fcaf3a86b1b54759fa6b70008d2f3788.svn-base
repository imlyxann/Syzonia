package fr.syzonia.moderationtool.cmds;

import java.util.UUID;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.BanManager;
import fr.syzonia.syzodb.mysql.PlayerInfo;

public class UnBanCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;
		
		if(PlayerInfo.getInfos(player.getUniqueId()).getRank() >= 5) {
		     if(args.length != 1){
		            sender.sendMessage("§c/unban <joueur>");
		            return true;
		        }
			
			String targetName = args[0];
			
			UUID targetUUID = BanManager.getUUID(targetName);
			System.out.println(targetUUID);
			   
			if(!new BanManager().isBanned(targetUUID)) {
				player.sendMessage("§cCe(tte) joueur(seu) n'est pas banni(e)");
				return true;
			} else {
				if (new BanManager().isBanned(targetUUID)) {
					new BanManager().unban(targetUUID);
					player.sendMessage("§6Vous avez débanni §a" + targetName);
				}
			}
		} else {
			player.sendMessage("§cTu n'as pas la perm petit debilos!");
		}
		
		return false;
	}

}
