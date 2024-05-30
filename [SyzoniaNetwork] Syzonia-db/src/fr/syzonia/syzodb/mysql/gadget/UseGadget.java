package fr.syzonia.syzodb.mysql.gadget;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.MySql;

public class UseGadget {

	public void setGadgetInUse(UUID uuid, int i) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET use_gadget = ? WHERE uuid_player = ?");
				preparedStatement.setInt(1, i);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getGadgetInUse(UUID uuid) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT use_gadget FROM players WHERE uuid_player = ?");
				preparedStatement.setString(1, uuid.toString());
				ResultSet rs = preparedStatement.executeQuery();
				int use_gadget = 0;
						while (rs.next()) {
							use_gadget = rs.getInt("use_gadget");
						}
						preparedStatement.close();
				return use_gadget;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
	
}
