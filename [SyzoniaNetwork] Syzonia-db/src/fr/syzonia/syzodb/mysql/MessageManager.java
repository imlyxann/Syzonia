package fr.syzonia.syzodb.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MessageManager {

	public void setLastMessage(UUID uuid, String message) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET LastMessageInChat = ? WHERE uuid_player = ?");
				preparedStatement.setString(1, message);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getLastMessage(UUID uuid) {
		try {
			PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT LastMessageInChat FROM players WHERE uuid_player = ?");
			preparedStatement.setString(1, uuid.toString());
			ResultSet rs = preparedStatement.executeQuery();
			String message = "";
					while (rs.next()) {
						message = rs.getString("LastMessageInChat");
					}
					preparedStatement.close();
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
	
