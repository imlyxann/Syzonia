package fr.syzonia.syzodb.mysql.mount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.MySql;

public class UseMount {

	public void setMountInUse(UUID uuid, int i) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET use_mount = ? WHERE uuid_player = ?");
				preparedStatement.setInt(1, i);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getMountInUse(UUID uuid) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT use_mount FROM players WHERE uuid_player = ?");
				preparedStatement.setString(1, uuid.toString());
				ResultSet rs = preparedStatement.executeQuery();
				int use_mount = 0;
						while (rs.next()) {
							use_mount = rs.getInt("use_mount");
						}
						preparedStatement.close();
				return use_mount;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
	
}
