
package fr.syzonia.lydrageanas.servers;

import java.sql.PreparedStatement;



import java.sql.ResultSet;
import java.sql.SQLException;

import fr.syzonia.bungeedb.mysql.DatabaseManager;



public class ServersCommon {

	public String table = "servers";
	
	private String displayName;
	
	public ServersCommon(String displayName) {
		this.displayName = displayName;
	}
	
	public String getName() {
		return displayName;
	}
	
	public int getPort() {
		try {
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT port FROM " + table + " WHERE server_name = ?");
			preparedStatement.setString(1, displayName);
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
	
	public String getAdress() {
		try {
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT ip FROM " + table + " WHERE server_name = ?");
			preparedStatement.setString(1, displayName);
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
	
	public int getStatus() {
		try {
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT status FROM " + table + " WHERE server_name = ?");
			preparedStatement.setString(1, displayName);
			ResultSet rs = preparedStatement.executeQuery();
			int status = 0;
			
			while (rs.next()) {
				status = rs.getInt("status");
			}
			preparedStatement.close();
			
			return status;
		} catch (SQLException e) {
		e.printStackTrace();
		return 0;
		}
	}
	
	public void setStatus(int status) {
		try {
			
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("UPDATE " + table + " SET status = ? WHERE server_name = ?");
			stat.setInt(1, status);
			stat.setString(2, displayName);
			stat.executeUpdate();
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
