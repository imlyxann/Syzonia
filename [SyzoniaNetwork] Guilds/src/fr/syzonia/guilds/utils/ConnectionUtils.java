package fr.syzonia.guilds.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.bungeedb.mysql.DatabaseManager;

public class ConnectionUtils {

	public static boolean getBungeeConnected(UUID uuid) {
		try {
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT isBungeeConnected FROM connection WHERE uuid_player = ?");
			preparedStatement.setString(1, uuid.toString());
			ResultSet rs = preparedStatement.executeQuery();
			boolean yes = false;
					while (rs.next()) {
						yes = rs.getBoolean("isBungeeConnected");
					}
					preparedStatement.close();
			return yes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
