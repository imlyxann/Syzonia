package fr.syzonia.syzodb.mysql.data;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.MySql;


public class PlayerData {
	private UUID uuid;
	
	public PlayerData(UUID uuid) {
		this.uuid = uuid;
	}
	
	public int getRank() {
		try {
			
			PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT grade FROM players WHERE uuid_player = ?");
			preparedStatement.setString(1, uuid.toString());
			int power = 0;
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				power = rs.getInt("grade");
			}
			preparedStatement.close();
			
			return power;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public void setRank(int power) {
		try {
			PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET grade = ? WHERE uuid_player = ?");
			preparedStatement.setInt(1, power);
			preparedStatement.setString(2, uuid.toString());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void addCoins(long amount) {
		try {
			PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET coins = coins + ? WHERE uuid_player = ?");
			preparedStatement.setLong(1, amount);
			preparedStatement.setString(2, uuid.toString());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeCoins(long amount) {
		try {
			PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET coins = coins - ? WHERE uuid_player = ?");
			preparedStatement.setLong(1, amount);
			preparedStatement.setString(2, uuid.toString());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public long getCoins() {
		try {
			PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT coins FROM players WHERE uuid_player = ?");
			preparedStatement.setString(1, uuid.toString());
			ResultSet rs = preparedStatement.executeQuery();
			long coins = 0;
					while (rs.next()) {
						coins = rs.getLong("coins");
					}
					preparedStatement.close();
			return coins;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
