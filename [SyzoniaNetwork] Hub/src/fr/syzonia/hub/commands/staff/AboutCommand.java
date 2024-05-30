package fr.syzonia.hub.commands.staff;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.Main;
import fr.syzonia.syzodb.mysql.MessageManager;
import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.mysql.RewardsManager;
import fr.syzonia.syzodb.mysql.data.PlayerData;
import fr.syzonia.syzodb.mysql.host.HostTicket;

public class AboutCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;
		PlayerInfo plinfo = PlayerInfo.getInfos(player.getUniqueId());
		
		if(sender instanceof Player) {
			if(plinfo.getRank() >= 5) {
				if(args.length == 1) {
					String target = args[0];
					UUID targetUUID = getUUID(target);
					PlayerData targetInfo = new PlayerData(targetUUID);
					
					if(targetUUID == null) {
						player.sendMessage("§cJoueur Inconnu");
						return false;
					}
					
					player.sendMessage("");
					player.sendMessage("§6-----------------------------------------");
					player.sendMessage("§d" + target + " §f: §d" + targetUUID );
					player.sendMessage("§aRank: " + Main.database.getRankName(targetUUID));
					player.sendMessage("§aCoins: §e" + targetInfo.getCoins());
					player.sendMessage("§aLastMessage: §e" + new MessageManager().getLastMessage(targetUUID));
					player.sendMessage("§aHostTicket: §e" + new HostTicket().getHostTicket(targetUUID));
					player.sendMessage("§aCanseePlayer: §e" + Main.database.getSeePlayer(targetUUID));
					player.sendMessage("§aReward: §e" + new RewardsManager().getRewardsFound(targetUUID));
					player.sendMessage("§6-----------------------------------------");
					player.sendMessage("");
					
				} else {
					player.sendMessage("§c/about <Player>");
					return false;
				}
			}
		} else {
			return false;
		}
		
		return true;
	}

	public static UUID getUUID(String playername) {
		try {
			PreparedStatement stats = MySql.getConnexion().prepareStatement("SELECT uuid_player FROM players WHERE pseudo_player = ?");
			stats.setString(1, playername);
			ResultSet rs = stats.executeQuery();
			
			while(rs.next()) {
				return UUID.fromString(rs.getString("uuid_player"));
			}
			stats.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
