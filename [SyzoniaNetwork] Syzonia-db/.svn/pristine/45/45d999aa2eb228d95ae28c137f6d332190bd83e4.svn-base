package fr.syzonia.syzodb.mysql.queue;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.mysql.PlayerInfo;

public class QueueManager {

	public void addQueudedPlayer(Player player, int Minigame, String minigametype, int Progress) {
		try {
			
			if(!isInQueue(player)) {
				PreparedStatement stat = MySql.getConnexion().prepareStatement("INSERT INTO queue (uuid_player, pseudo_player, player_grade, minigame, minigame_type, progress, redirectserver) VALUE (?, ?, ?, ?, ?, ?, ?)");
				stat.setString(1, player.getUniqueId().toString());
				stat.setString(2, player.getName());
				stat.setDouble(3, new PlayerInfo(player.getUniqueId()).getRank());
				stat.setInt(4, Minigame);
				stat.setString(5, minigametype);
				stat.setInt(6, Progress);
				stat.setString(7, "");
				stat.execute();
				stat.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdatePlayer(Player player, int MiniGame, String minigametype, int progress) {
		if (isInQueue(player)) {
			try {
				PreparedStatement stat = MySql.getConnexion().prepareStatement("UPDATE queue SET uuid_player = ?, pseudo_player = ?, player_grade = ?, minigame = ?, minigame_type = ?, redirectserver = ? WHERE uuid_player = '" + player.getUniqueId() + "'");
				stat.setString(1, player.getUniqueId().toString());
				stat.setString(2, player.getName());
				stat.setDouble(3, new PlayerInfo(player.getUniqueId()).getRank());
				stat.setInt(4, MiniGame);
				stat.setString(5, minigametype);
				stat.setInt(6, progress);
				stat.setString(7, "");
				stat.executeUpdate();
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return;
		}
	}
	
	public void removePlayer(Player player) {
		try {
			PreparedStatement stat = MySql.getConnexion().prepareStatement("DELETE FROM queue WHERE uuid_player = ?");
			stat.setString(1, player.getUniqueId().toString());
			stat.executeUpdate();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Player getPlayer(Player name) {
		try {
			PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT * FROM queue WHERE uuid_player = ?");
			stat.setString(1, name.getUniqueId().toString());
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				return Bukkit.getPlayer(rs.getString("pseudo_player"));
			}
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public int getMiniGame(Player name) {
		try {
			PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT * FROM queue WHERE uuid_player = ?");
			stat.setString(1, name.getUniqueId().toString());
			ResultSet rs = stat.executeQuery();
			int minigame = 0;
			
			while (rs.next()) {
				minigame = rs.getInt(5);
				return minigame;
			}
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
	public String getMiniGameType(Player name) {
		try {
			PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT * FROM queue WHERE uuid_player = ?");
			stat.setString(1, name.getUniqueId().toString());
			ResultSet rs = stat.executeQuery();
			String type = "";
			
			while (rs.next()) {
				type = rs.getString(6);
				return type;
			}
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
		return "";
	}
	
	public boolean isInQueue(Player player) {
		try {
			PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT pseudo_player FROM queue WHERE uuid_player = ?");
			stat.setString(1, player.getUniqueId().toString());
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				return true;
			}
			
			stat.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
}
