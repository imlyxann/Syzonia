package fr.syzonia.syzodb.mysql.particules;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.MySql;

public class UseParticules {

	
	public void setParticulesUse(UUID uuid, int i) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET use_particules = ? WHERE uuid_player = ?");
				preparedStatement.setInt(1, i);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getParticulesInUse(UUID uuid) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT use_particules FROM players WHERE uuid_player = ?");
				preparedStatement.setString(1, uuid.toString());
				ResultSet rs = preparedStatement.executeQuery();
				int particules = 0;
						while (rs.next()) {
							particules = rs.getInt("use_particules");
						}
						preparedStatement.close();
				return particules;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
	
}
