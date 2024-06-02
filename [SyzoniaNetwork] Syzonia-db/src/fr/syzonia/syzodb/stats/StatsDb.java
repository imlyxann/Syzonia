package fr.syzonia.syzodb.stats;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.Main;
import fr.syzonia.syzodb.mysql.MySql;

public class StatsDb {

	public void create(Player player) {
		if(!Main.database.hasAccount(player.getUniqueId())) {
			try {
				PreparedStatement stat = MySql.connection.prepareStatement("INSERT INTO stats (uuid_player, pseudo_player, ck_total, ck_win, ck_defeat) VALUES (?, ?, ?, ?, ?)");
				stat.setString(1, player.getUniqueId().toString());
				stat.setString(2, player.getName());
				stat.setInt(3, 0);
				stat.setInt(4, 0);
				stat.setInt(5, 0);
				stat.execute();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getWin(Player player) {
		if(!Main.database.hasAccount(player.getUniqueId())) {
			try {
				PreparedStatement stat = MySql.connection.prepareStatement("SELECT ck_win FROM stats WHERE uuid_player = '" + player.getUniqueId() + "'");
				ResultSet rs = stat.executeQuery();
				
				if(rs.next()) {
					return rs.getInt("ck_win");
				}
				
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		return 0;
	}
	
	public int getTotal(Player player) {
		if(!Main.database.hasAccount(player.getUniqueId())) {
			try {
				PreparedStatement stat = MySql.connection.prepareStatement("SELECT ck_total FROM stats WHERE uuid_player = '" + player.getUniqueId() + "'");
				ResultSet rs = stat.executeQuery();
				
				if(rs.next()) {
					return rs.getInt("ck_total");
				}
				
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		return 0;
	}
	
	public int getDefeat(Player player) {
		if(!Main.database.hasAccount(player.getUniqueId())) {
			try {
				PreparedStatement stat = MySql.connection.prepareStatement("SELECT ck_defeat FROM stats WHERE uuid_player = '" + player.getUniqueId() + "'");
				ResultSet rs = stat.executeQuery();
				
				if(rs.next()) {
					return rs.getInt("ck_defeat");
				}
				
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		return 0;
	}
	
	public void addWin(Player player) {
		if(!Main.database.hasAccount(player.getUniqueId())) {
			try {
				int count = getWin(player) + 1;
				PreparedStatement stat = MySql.connection.prepareStatement("UPDATE stats SET ck_win = '" + count + "' WHERE uuid_player = '" + player.getUniqueId() + "'");
				stat.executeUpdate();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addTotal(Player player) {
		if(!Main.database.hasAccount(player.getUniqueId())) {
			try {
				int count = getTotal(player) + 1;
				PreparedStatement stat = MySql.connection.prepareStatement("UPDATE stats SET ck_total = '" + count + "' WHERE uuid_player = '" + player.getUniqueId() + "'");
				stat.executeUpdate();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addDefeat(Player player) {
		if(!Main.database.hasAccount(player.getUniqueId())) {
			try {
				int count = getDefeat(player) + 1;
				PreparedStatement stat = MySql.connection.prepareStatement("UPDATE stats SET ck_defeat = '" + count + "' WHERE uuid_player = '" + player.getUniqueId() + "'");
				stat.executeUpdate();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
