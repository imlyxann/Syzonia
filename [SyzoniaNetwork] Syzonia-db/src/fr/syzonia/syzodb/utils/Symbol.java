package fr.syzonia.syzodb.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.mysql.PlayerInfo;

public class Symbol {

	public String getSymbol(UUID uuid) {
		PlayerInfo playerinfo = PlayerInfo.getInfos(uuid);
		
		if(playerinfo.getRank() == 3) {
			switch (getBddSymbol(uuid)) {
			case 1:
				
				return "☯";
				
			case 2:
				
				return "☢";
				
			case 3:
				
				return "♛";
				
			case 4:
				
				return "☃";
				
			case 5:
				
				return "✿";
				
			case 6:
				
				return "♫";
				
			case 7:
				
				return "☄";
				
			case 8:
				
				return "★";

			default:
				break;
			}
		}
		
		return null;
		
		
	}
	
	public void setSymbol(UUID uuid, int symbol) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players_data SET Legend_Symbol = ? WHERE uuid_player = ?");
				preparedStatement.setInt(1, symbol);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int getBddSymbol(UUID uuid) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT Legend_Symbol FROM players_data WHERE uuid_player = ?");
				preparedStatement.setString(1, uuid.toString());
				ResultSet rs = preparedStatement.executeQuery();
				int symbol = 0;
						while (rs.next()) {
							symbol = rs.getInt("Legend_Symbol");
						}
						preparedStatement.close();
				return symbol;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
	
}

