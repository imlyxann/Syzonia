package fr.syzonia.syzobungee.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.syzonia.bungeedb.mysql.DatabaseManager;

public class ServerComponent {

	public static String table = "servers";
	
	public static int getPort(String servername) {
		try {
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT port FROM " + table + " WHERE server_name = ?");
			preparedStatement.setString(1, servername);
			ResultSet rs = preparedStatement.executeQuery();
			int port = 0;
			
			while (rs.next()) {
				port = rs.getInt("port");
			}
			preparedStatement.close();
			
			return port;
			
		} catch (SQLException e) {
		e.printStackTrace();
		return 0;
		}
	}
	
	public static String getAdress(String servername) {
		try {
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT ip FROM " + table + " WHERE server_name = ?");
			preparedStatement.setString(1, servername);
			ResultSet rs = preparedStatement.executeQuery();
			String ip = "";
			
			while (rs.next()) {
				 ip = rs.getString("ip");
			}
			preparedStatement.close();
			
			return ip;
			
		} catch (SQLException e) {
		e.printStackTrace();
		return "";
		}
	}
}
