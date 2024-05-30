package fr.syzonia.syzodb.mysql.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.MySql;

public class PlayerBdd {

	public int isAllow(String pseudo) {
		try {
			
			PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT friends_allow FROM player_friends_allow WHERE pseudo_player = ?");
			stat.setString(1, pseudo);
			ResultSet rs = stat.executeQuery();
			int allow = 0;
			
			while(rs.next()) {
				allow = rs.getInt("friends_allow");
			}
			stat.close();
			
			return allow;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}
	
	public void setAllow(int i, String pseudo) {
		try {
			
			PreparedStatement stat = MySql.getConnexion().prepareStatement("UPDATE player_friends_allow SET friends_allow = ? WHERE pseudo_player = ?");
			stat.setInt(1, i);
			stat.setString(2, pseudo);
			stat.executeUpdate();
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int isEnabled(UUID pseudo) {
		try {
			
			PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT msg FROM players_data WHERE uuid_player = ?");
			stat.setString(1, pseudo.toString());
			ResultSet rs = stat.executeQuery();
			int allow = 0;
			
			while(rs.next()) {
				allow = rs.getInt("msg");
			}
			stat.close();
			
			return allow;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}
	
	public void setEnabled(int i, UUID pseudo) {
		try {
			
			PreparedStatement stat = MySql.getConnexion().prepareStatement("UPDATE players_data SET msg = ? WHERE uuid_player = ?");
			stat.setInt(1, i);
			stat.setString(2, pseudo.toString());
			stat.executeUpdate();
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
