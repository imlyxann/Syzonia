package fr.syzonia.syzodb.mysql.pet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.MySql;

public class UsePet {

	public void setPetInUse(UUID uuid, int i) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET use_pets = ? WHERE uuid_player = ?");
				preparedStatement.setInt(1, i);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getPetInUse(UUID uuid) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT use_pets FROM players WHERE uuid_player = ?");
				preparedStatement.setString(1, uuid.toString());
				ResultSet rs = preparedStatement.executeQuery();
				int use_pets = 0;
						while (rs.next()) {
							use_pets = rs.getInt("use_pets");
						}
						preparedStatement.close();
				return use_pets;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
	
}
