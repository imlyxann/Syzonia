package fr.syzonia.syzodb.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class OpManager {

	public void createOPAccount(UUID uuid) {
		if(!hasAccount(uuid)) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("INSERT INTO player_op (uuid_player, pseudo_player, isop) VALUES (?, ?, ?)");
				preparedStatement.setString(1, uuid.toString());
				preparedStatement.setString(2, Bukkit.getPlayer(uuid).getName());
				preparedStatement.setBoolean(3, false);
				preparedStatement.execute();
				preparedStatement.close();
 
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
 
	public boolean hasAccount(UUID uuid) {
		try {
		    PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT isop FROM player_op WHERE uuid_player = ?");
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
	
	
	public void setop(Player player, int i) {
			try {
					PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE player_op SET isop = ? WHERE uuid_player = ?");
					preparedStatement.setInt(1, i);
					preparedStatement.setString(2, player.getUniqueId().toString());
					preparedStatement.executeUpdate();
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
	
