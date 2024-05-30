package fr.syzonia.bungeedb.mysql;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HubManager {

	
	public void addHub(String name, String ip, int port, int value) {
		if(!isAdded(name)) {
			try {
				PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("INSERT INTO hubs (server_name, ip, port, players_value) VALUES (?, ?, ?, ?)");
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
		    PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT server_name FROM hubs WHERE server_name = ?");
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
			PreparedStatement sts = DatabaseManager.getConnexion().prepareStatement("DELETE FROM hubs WHERE server_name = ?");
			sts.setString(1, name);
			sts.executeUpdate();
            sts.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getHubName() {
		
	}
	
	public List<String> getHubs() {
		try {
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT * FROM `hubs` WHERE 1");
		    ResultSet rs = preparedStatement.executeQuery();
		    List<String> hubs = new ArrayList<String>();
		    
		    	while(rs.next()) {
		    		hubs.add(rs.getString("server_name"));
		    	}
		    preparedStatement.close();
		    
		    return hubs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
}
	
	public Integer getHubPlayers(String name) {
		try {
				PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT players_value FROM hubs WHERE server_name = ?");
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

	
	public List<String> getHubWithPlayers(int x) {
		List<String> hubs = new ArrayList<String>();
		try {
				
		    for(String list : getHubs()) {
		    	if(getHubPlayers(list) == x) {
		    		hubs.add(list);
		    	}
		    }
		    
		    return hubs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getIp(String name) {
		try {
				PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT ip FROM hubs WHERE server_name = ?");
				preparedStatement.setString(1, name);
				ResultSet rs = preparedStatement.executeQuery();
				String value = "";
		    
				while(rs.next()) {
					value = rs.getString("ip");
				}
				preparedStatement.close();
		    
		    return value;
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public Integer getPort(String name) {
		try {
				PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT port FROM hubs WHERE server_name = ?");
				preparedStatement.setString(1, name);
				ResultSet rs = preparedStatement.executeQuery();
				int value = 0;
		    
				while(rs.next()) {
					value = rs.getInt("port");
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
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT * FROM `hubs` WHERE 1");
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
					PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("UPDATE hubs SET players_value = ? WHERE server_name = ?");
					preparedStatement.setInt(1, i);
					preparedStatement.setString(2, name);
					preparedStatement.executeUpdate();
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	
}
