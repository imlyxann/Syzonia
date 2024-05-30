package fr.syzonia.syzobungee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import net.md_5.bungee.api.ProxyServer;



public class PlayerConnections {

	public void createConnectionAccount(UUID uuid) {
		if(!hasConnectionAccount(uuid)) {
			try {
				PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("INSERT INTO connection (uuid_player, pseudo_player, isBungeeConnected, isSpigotConnected) VALUES (?, ?, ?, ?)");
				preparedStatement.setString(1, uuid.toString());
				preparedStatement.setString(2, ProxyServer.getInstance().getPlayer(uuid).getName());
				preparedStatement.setBoolean(3, true);
				preparedStatement.setBoolean(4, true);
				preparedStatement.execute();
				preparedStatement.close();
 
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
 
	public boolean hasConnectionAccount(UUID uuid) {
		try {
		    PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT pseudo_player FROM connection WHERE uuid_player = ?");
		    preparedStatement.setString(1, uuid.toString());
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
	
	public void setBungeeConnected(UUID uuid, Boolean i) {
		try {
				PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("UPDATE connection SET isBungeeConnected = ? WHERE uuid_player = ?");
				preparedStatement.setBoolean(1, i);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getBungeeConnected(UUID uuid) {
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
	
	public void createAc(UUID uuid) {
		if(!hasAc(uuid)) {
			try {
				PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("INSERT INTO connection_server (uuid_player, server_name) VALUES (?, ?)");
				preparedStatement.setString(1, uuid.toString());
				preparedStatement.setString(2, null);
				preparedStatement.execute();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



	public boolean hasAc(UUID uuid) {
		try {
		    PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT uuid_player FROM connection_server WHERE uuid_player = ?");
		    preparedStatement.setString(1, uuid.toString());
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
	
}
