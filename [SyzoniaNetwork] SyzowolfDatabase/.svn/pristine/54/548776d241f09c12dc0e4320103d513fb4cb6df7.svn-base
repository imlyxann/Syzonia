package fr.syzonia.syzowolfdb.violations;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;

import fr.syzonia.syzowolfdb.mysql.SyzoWolfDatabaseManager;



public class ViolationManager {

	public void addViolations(UUID uuid, String type, String cache) {
			try {
				PreparedStatement preparedStatement = SyzoWolfDatabaseManager.getConnexion().prepareStatement("INSERT INTO violations (uuid_player, pseudo_player, violations_type, violations_cache) VALUES (?, ?, ?, ?)");
				preparedStatement.setString(1, uuid.toString());
				preparedStatement.setString(2, Bukkit.getPlayer(uuid).getName());
				preparedStatement.setString(3, type);
				preparedStatement.setString(4, cache);
				preparedStatement.execute();
				preparedStatement.close();
 
			} catch (SQLException e){
				e.printStackTrace();
		}
	}
 
	public void deleteViolations(UUID uuid) {
		try {
			PreparedStatement stat = SyzoWolfDatabaseManager.getConnexion().prepareStatement("DELETE FROM violations WHERE uuid_player = '" + uuid.toString() + "'");
			stat.executeUpdate();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

