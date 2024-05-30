package fr.syzonia.syzodb.hubjump;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.MySql;


public class HubJumpManager {
	
	// Pour plus tard!
	
	public void JumpStart(Player player) {
		if(!isInJump(player.getUniqueId())) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("INSERT INTO hubjump (uuid_player, pseudo_player, jumpid) VALUES (?, ?, ?)");
				preparedStatement.setString(1, player.getUniqueId().toString());
				preparedStatement.setString(2, player.getName());
				preparedStatement.setInt(3, 1);
				preparedStatement.execute();
				preparedStatement.close();
 
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
 
	public boolean isInJump(UUID uuid) {
		try {
		    PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT jumpid FROM hubjump WHERE uuid_player = ?");
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
	
	
	public void JumpEnd(Player player, int i) {
		try {
			PreparedStatement sts = MySql.getConnexion().prepareStatement("DELETE FROM hubjump WHERE uuid_player = ?");
			sts.setString(1, player.getUniqueId().toString());
			sts.executeUpdate();
            sts.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Integer getJumpId(Player player) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT jumpid FROM hubjump WHERE uuid_player = ?");
				preparedStatement.setString(1, player.getUniqueId().toString());
			    ResultSet rs = preparedStatement.executeQuery();
			    int End = 0;
			    
			    while(rs.next()) {
			    	End = rs.getInt("jumpid");
			    }
			    preparedStatement.close();
			    
			    return End;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void setJumpId(Player player, int i) {
			try {
					PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE hubjump SET jumpid = ? WHERE uuid_player = ?");
					preparedStatement.setInt(1, i);
					preparedStatement.setString(2, player.getUniqueId().toString());
					preparedStatement.executeUpdate();
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
