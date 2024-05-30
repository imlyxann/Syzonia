package fr.syzonia.syzodb.mysql;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ServerName {
	
	public static void setServerName(UUID uuid, String servername) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE connection_server SET server_name = ? WHERE uuid_player = ?");
				preparedStatement.setString(1, servername);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getServerName(UUID uuid) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT server_name FROM connection_server WHERE uuid_player = ?");
				preparedStatement.setString(1, uuid.toString());
				ResultSet rs = preparedStatement.executeQuery();
				String server = "";
						while (rs.next()) {
							server = rs.getString("server_name");
						}
						preparedStatement.close();
				return server;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "";
		}
}
