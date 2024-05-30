package fr.syzonia.hub.commands.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.core.npc.NpcManager;
import fr.syzonia.syzodb.mysql.PlayerInfo;

public class EventCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		
		if(PlayerInfo.getInfos(player.getUniqueId()).getRank() >= 5) {

			switch (args[0]) {
			case "add":
				
				if(args[1] != null) {
					switch (args[2]) {
					case "CK":
						
						String CKname = args[3].replace("&", "§");
						
						NpcManager.spawnEventNpc(player.getLocation(), Integer.parseInt(args[1]), CKname, 1, args[4], player.getLocation().getYaw());
						
						break;
						
					case "LG":
						
						String LGname = args[3].replace("&", "§");
						
						NpcManager.spawnEventNpc(player.getLocation(), Integer.parseInt(args[1]), LGname, 1, args[4], player.getLocation().getYaw());
						
						break;

					default:
						break;
					}
				}
				
				break;
				
			case "remove":
				
				if(NpcManager.EventNpc.containsKey(Integer.parseInt(args[1]))) {
					NpcManager.removeNpcEvent(Integer.parseInt(args[1]));
				}
			}
			
		}	
		
		return true;

	}

	
}
