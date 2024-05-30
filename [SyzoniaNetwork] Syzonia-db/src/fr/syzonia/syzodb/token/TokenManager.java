package fr.syzonia.syzodb.token;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;

import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.utils.TimeUnit;

public class TokenManager {

	
	public void createToken(UUID uuid, long endInSeconds, String reason){
	        if(TokenIsCreate(uuid)) {
	        	return;
	        }
	 
	        long endToMillis = endInSeconds * 1000;
	        long end = endToMillis + System.currentTimeMillis();
	 
	        if(endInSeconds == -1){
	            end = -1;
	        }
	 
	        try {
	            PreparedStatement sts = MySql.getConnexion().prepareStatement("INSERT INTO tokens (uuid_player, pseudo_player, token, expire) VALUES (?, ?, ?, ?)");
	            sts.setString(1, uuid.toString());
	            sts.setString(2, Bukkit.getPlayer(uuid).getName());
	            sts.setString(3, UUID.randomUUID().toString());
	            sts.setLong(4, end);
	            sts.executeUpdate();
	            sts.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public void deleteToken(UUID uuid){
	        if(!TokenIsCreate(uuid)) {
	        	return;
	        }
	 
	        try {
	            PreparedStatement sts = MySql.getConnexion().prepareStatement("DELETE FROM tokens WHERE uuid_player = ?");
	            sts.setString(1, uuid.toString());
	            sts.executeUpdate();
	            sts.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public boolean TokenIsCreate(UUID uuid){
	        try {
	            PreparedStatement sts = MySql.getConnexion().prepareStatement("SELECT * FROM tokens WHERE uuid_player = ?");
	            sts.setString(1, uuid.toString());
	            ResultSet rs = sts.executeQuery();
	            return rs.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	    public void checkDuration(UUID uuid){
	        if(!TokenIsCreate(uuid)) return;
	 
	        if(getEnd(uuid) == -1) return;
	 
	        if(getEnd(uuid) < System.currentTimeMillis()){
	        	deleteToken(uuid);
	        }
	    }
	 
	    public long getEnd(UUID uuid){
	        if(!TokenIsCreate(uuid)) {
	        	return 0;
	        }
	 
	        try {
	            PreparedStatement sts = MySql.getConnexion().prepareStatement("SELECT * FROM tokens WHERE uuid_player = ?");
	            sts.setString(1, uuid.toString());
	            ResultSet rs = sts.executeQuery();
	            
	            if(rs.next()){
	                return rs.getLong("expire");
	            }
	            
	            sts.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
	    

	    public String getToken(UUID uuid){
	        if(!TokenIsCreate(uuid)) {
	        	return "";
	        }
	 
	        try {
	            PreparedStatement sts = MySql.getConnexion().prepareStatement("SELECT * FROM tokens WHERE uuid_player = ?");
	            sts.setString(1, uuid.toString());
	            ResultSet rs = sts.executeQuery();
	            
	            if(rs.next()){
	                return rs.getString("token");
	            }
	            
	            sts.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return "";
	    }
	 
	   
	    public String getTimeLeft(UUID uuid){
	        if(!TokenIsCreate(uuid)) return "§cToken non crée";
	 
	        if(getEnd(uuid) == -1){
	            return "§cPermanent";
	        }
	 
	        long tempsRestant = (getEnd(uuid) - System.currentTimeMillis()) / 1000;
	        int minutes = 0;
	 
	 
	        while(tempsRestant >= TimeUnit.MINUTE.getToSecond()){
	            minutes++;
	            tempsRestant -= TimeUnit.MINUTE.getToSecond();
	        }
	 
	        // 1 Mois, 1 Jour(s), 12 Heure(s), 32 Minute(s), 12 Seconde(s)
	        return  minutes + " " + TimeUnit.MINUTE.getName() ;
	   
	    }
}
