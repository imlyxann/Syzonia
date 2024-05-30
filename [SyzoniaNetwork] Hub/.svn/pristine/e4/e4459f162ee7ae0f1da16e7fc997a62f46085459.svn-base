package fr.syzonia.hub.commands.staff;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.PlayerInfo;

public class ShutUpCommand implements CommandExecutor {

	public static boolean ShutUp = false; 
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;
		
		if(sender instanceof Player) {
			
			if(PlayerInfo.getInfos(player.getUniqueId()).getRank() >= 5) {
				if(ShutUp) {
					ShutUp = false;
					player.sendMessage("§aVous avez débouclé le chat");
					Bukkit.broadcastMessage("§2Le Chat a été débouclé par §e" + player.getName());
				} else {
					ShutUp = true;
					player.sendMessage("§aVous avez bouclé le chat");
					Bukkit.broadcastMessage("§2Le Chat a été bouclé par §e" + player.getName());
				}
			}
			
		} else {
			return false;
		}
		
		return true;
	}

}
