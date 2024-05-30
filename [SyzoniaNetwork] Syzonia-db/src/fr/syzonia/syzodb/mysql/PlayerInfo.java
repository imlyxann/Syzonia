package fr.syzonia.syzodb.mysql;


import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.syzodb.mysql.data.PlayerData;

public class PlayerInfo {

	private UUID uuid;
	private PlayerData playerData;
	
	public PlayerInfo(UUID uuid) {
		this.setUuid(uuid);
		this.playerData = new PlayerData(uuid);
	}
	
	public static PlayerInfo getInfos(UUID playeruuid) {
		PlayerInfo playerinfo = new PlayerInfo(playeruuid);
		return playerinfo;
	}
	
	public PlayerData getPlayerData() {
		return playerData;
	}
	
	public long getCoinsNumber() {
		return playerData.getCoins();
	}
	
	public void addCoins(long amount) {
		playerData.addCoins(amount);
		
	}
	
	public void removeCoins(long amount) {
		playerData.removeCoins(amount);
	}
	
	public int getRank() {
		return playerData.getRank();
    }
	
	public void setRank(int power) {
		playerData.setRank(power);
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	public boolean isBanned(UUID uuid){
        try {
            PreparedStatement sts = MySql.getConnexion().prepareStatement("SELECT * FROM bans WHERE player_uuid = ?");
            sts.setString(1, uuid.toString());
            ResultSet rs = sts.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
  
}
