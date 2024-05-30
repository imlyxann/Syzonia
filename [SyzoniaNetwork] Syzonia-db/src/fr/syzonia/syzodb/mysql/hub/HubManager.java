package fr.syzonia.syzodb.mysql.hub;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.syzonia.syzodb.hub.DatabaseConnect;

public class HubManager {

	
	public void addHub(String name, String ip, int port, int value) {
		if(!isAdded(name)) {
			try {
				PreparedStatement preparedStatement = DatabaseConnect.getConnexion().prepareStatement("INSERT INTO hubs (server_name, ip, port, players_value) VALUES (?, ?, ?, ?)");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, ip);
				preparedStatement.setInt(3, port);
				preparedStatement.setInt(4, value);
				preparedStatement.execute();
				preparedStatement.close();
 
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
 
	public boolean isAdded(String name) {
		try {
		    PreparedStatement preparedStatement = DatabaseConnect.getConnexion().prepareStatement("SELECT server_name FROM hubs WHERE server_name = ?");
		    preparedStatement.setString(1, name);
		    ResultSet rs = preparedStatement.executeQuery();
 
		    while(rs.next()) {
		    	return true;
		    }
		    return false;
 
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void removeHub(String name) {
		try {
			PreparedStatement sts = DatabaseConnect.getConnexion().prepareStatement("DELETE FROM hubs WHERE server_name = ?");
			sts.setString(1, name);
			sts.executeUpdate();
            sts.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Integer getHubPlayers(String name) {
		try {
				PreparedStatement preparedStatement = DatabaseConnect.getConnexion().prepareStatement("SELECT players_value FROM hubs WHERE server_name = ?");
				preparedStatement.setString(1, name);
			    ResultSet rs = preparedStatement.executeQuery();
			    int value = 0;
			    
			    while(rs.next()) {
			    	value = rs.getInt("players_value");
			    }
			    preparedStatement.close();
			    
			    return value;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public Integer getAllHubs() {

		try {
			PreparedStatement preparedStatement = DatabaseConnect.getConnexion().prepareStatement("SELECT * FROM `hubs` WHERE 1");
		    ResultSet rs = preparedStatement.executeQuery();
		    int value = 0;
		    
		    while(rs.next()) {
		    	value++;
		    }
		    preparedStatement.close();
		    
		    return value;
	} catch (SQLException e) {
		e.printStackTrace();
		return 0;
	}
		
	}
	
	public void setHubPlayers(String name, int i) {
			try {
					PreparedStatement preparedStatement = DatabaseConnect.getConnexion().prepareStatement("UPDATE hubs SET players_value = ? WHERE server_name = ?");
					preparedStatement.setInt(1, i);
					preparedStatement.setString(2, name);
					preparedStatement.executeUpdate();
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	
}
