package fr.syzonia.syzodb.mysql.friends;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.MySql;


public class FriendBDD {

protected  String table = "players_friends";
	

	public void addFriend(UUID playeruuid, UUID targetuuid) {
		try {
			
			PreparedStatement stat = MySql.getConnexion().prepareStatement("INSERT INTO " + table + " (uuid_player, uuid_friend) VALUES (?, ?)");
			stat.setString(1, playeruuid.toString());
			stat.setString(2, targetuuid.toString());
			stat.execute();
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeFriend(String mainfriend, String secondFriend) {
		String uuid = MySql.getUUID(mainfriend).toString();
		String uuid_target = MySql.getUUID(secondFriend).toString();
		try {
			
			PreparedStatement stat = MySql.getConnexion().prepareStatement("DELETE FROM " + table + " WHERE " + "uuid_player = ? " + "and uuid_friend = ?");
			stat.setString(1, uuid);
			stat.setString(2, uuid_target);
			stat.executeUpdate();
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
	
	public List<String> getFriendList(String pseudo) {
		List<String> friendList = new ArrayList<String>();
		String uuid = MySql.getUUID(pseudo).toString();
		try {
			
			PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT uuid_friend FROM " + table + " WHERE uuid_player = ?");
			stat.setString(1, uuid);
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				friendList.add(MySql.getPseudo(UUID.fromString(rs.getString("uuid_friend"))));
			}
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return friendList;
		}
		return friendList;
	}
	
	public boolean isFriendWith(String mainfriend, String secondfriend) {
		if(getFriendList(mainfriend).contains(secondfriend)) return true;
		return false;
	}
	
	public int getFriendsCounter(String pseudo) {
		Integer counter = 0;
		String uuid = MySql.getUUID(pseudo).toString();
		try {
			
			PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT uuid_friend FROM " + table + " WHERE uuid_player = ?");
			stat.setString(1, uuid);
			ResultSet rs = stat.executeQuery();

			
			while(rs.next()) {
				counter++;
			}
			stat.close();
			
			return counter;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}
	
	
	
}
