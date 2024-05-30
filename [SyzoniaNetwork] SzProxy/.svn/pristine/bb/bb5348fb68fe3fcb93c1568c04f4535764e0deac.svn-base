package fr.syzonia.syzobungee.commands;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BroadCastCommand extends Command {

	public BroadCastCommand() {
		super("mod");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if(sender instanceof ProxiedPlayer) {
			if(DatabaseManager.getPlayerRank(player.getUniqueId()) >= 5) {
				 if (args.length > 0){
				        String sm = "";

				        for (int i = 0; i < args.length; i++){
				            String arg = ("§e" + args[i] + " ");
				            sm = ("§e" + sm + "§e" + arg);
				        }

				        for(ProxiedPlayer players : BungeeCord.getInstance().getPlayers()) {
				        	players.sendMessage(new TextComponent("§6---------------------------------------"));
				        	players.sendMessage(new TextComponent("§5[§dAnnonce§5] " + getRankName(player.getUniqueId()) + " " + player.getName() + " §7» " + sm));
				        	players.sendMessage(new TextComponent("§6---------------------------------------"));
				        	
				        }
				   }else{
					   player.sendMessage(ChatColor.RED + "§c Fais: /mod <message>");
				    }

			}
		}
		
		
	}
	
	public String getRankName(UUID uuid) {
		try {
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT grade_name FROM players WHERE uuid_player = ?");
			preparedStatement.setString(1, uuid.toString());
			ResultSet rs = preparedStatement.executeQuery();
			String rank = "";
					while (rs.next()) {
						rank = rs.getString("grade_name");
					}
					preparedStatement.close();
			return rank;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
