package fr.syzonia.syzodb.kits.cakewars;

import java.sql.PreparedStatement;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.bukkit.Bukkit;

import fr.syzonia.syzodb.mysql.MySql;



public enum CakeWarsKitsManager {
		Ranger(1, "Ranger"),
		Gladiator(2, "Gladiator");
		
		private int id;
		private String name;
		
		private CakeWarsKitsManager(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getID() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public boolean isExist(UUID uuid) {
			try {
				
				PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT pseudo_player FROM cakewars_kits WHERE uuid_player = ?");
				stat.setString(1, uuid.toString());
				ResultSet rs = stat.executeQuery();
				
				if(rs.next()) return true;
				stat.close();
				
				return false;
				
			} catch (SQLException err) {
				err.printStackTrace();
				return false;
			}
		}
		
		public void addKit(UUID uuid) {
			if(!isExist(uuid)) {
				try {
					
					PreparedStatement stat = MySql.getConnexion().prepareStatement("INSERT INTO cakewars_kits (uuid_player, pseudo_player, kit_" + this.getName() + ") VALUES (?, ?, ?)");
					stat.setString(1, uuid.toString());
					stat.setString(2, Bukkit.getPlayer(uuid).getName());
					stat.setInt(3, 1);
					stat.execute();
					stat.close();
				} catch (SQLException err) {
					err.printStackTrace();
				}
			} else {
				try {
					PreparedStatement stat = MySql.getConnexion().prepareStatement("UPDATE cakewars_kits SET kit_" + this.getName() + " = ? WHERE uuid_player = ?");
					stat.setInt(1, 1);
					stat.setString(2, uuid.toString());
					stat.executeUpdate();
					stat.close();
					
				} catch (SQLException err) {
					err.printStackTrace();
				}
			
			} 
		}
		
		public void test(UUID uuid) {
			try {
				PreparedStatement stat = MySql.getConnexion().prepareStatement("UPDATE cakewars_kits SET kit_" + this.getName() + " = ? WHERE uuid_player = ?");
				stat.setInt(1, 1);
				stat.setString(2, uuid.toString());
				stat.executeUpdate();
				stat.close();
				
			} catch (SQLException err) {
				err.printStackTrace();
			}
		}
		
		public int getPlayerKit(UUID uuid) {
			try {
				
				PreparedStatement stat = MySql.getConnexion().prepareStatement("SELECT kit_" + this.getName() + " FROM cakewars_kits WHERE uuid_player = ?");
				stat.setString(1, uuid.toString());
				ResultSet rs = stat.executeQuery();
				
				int kitpower = 0;
				
				if(rs.next()) {
					kitpower = rs.getInt("kit_" + this.getName());
				}
				
				stat.close();
				
				return kitpower;
			} catch (SQLException err) {
				err.printStackTrace();
				return 0;
			}
		}
		
	}


