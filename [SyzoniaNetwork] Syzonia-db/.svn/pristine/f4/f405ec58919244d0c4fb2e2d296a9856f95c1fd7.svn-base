package fr.syzonia.syzodb.mysql.host;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.MySql;

public class HostTicket {

	public void setHostTicket(UUID uuid, Double i) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET HostTicket = ? WHERE uuid_player = ?");
				preparedStatement.setDouble(1, i);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addHostTicket(UUID uuid, double i) {
		try {
			Double tickets = getHostTicket(uuid) + i;
			PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET HostTicket = ? WHERE uuid_player = ?");
			preparedStatement.setDouble(1, tickets);
			preparedStatement.setString(2, uuid.toString());
			preparedStatement.executeUpdate();
			preparedStatement.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public Double getHostTicket(UUID uuid) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT HostTicket FROM players WHERE uuid_player = ?");
				preparedStatement.setString(1, uuid.toString());
				ResultSet rs = preparedStatement.executeQuery();
				double tickets = 0;
						while (rs.next()) {
							tickets = rs.getDouble("HostTicket");
						}
						preparedStatement.close();
				return tickets;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0D;
		}
	
}
