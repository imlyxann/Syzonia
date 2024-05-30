package fr.syzonia.syzodb.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.utils.TimeUnit;

public class BanManager {

	public void ban(UUID uuid, long endInSeconds, String reason, String whoban){
		Player player = Bukkit.getPlayer(uuid);
        if(!isBanned(uuid)) {
        	
        	if(player != null) {
        		player.kickPlayer(
        		"§r----- §6§lSyzonia §r- §cSanction §r-----\n " +
	 			"§7» §e§lVous avez été banni de Syzonia..." +
	 			"\n" +
                "\n§7Motif: §4" + reason +
                "\n§cCette penalité prend dans " + getTimeWithoutSQL(uuid, getMillisEnd(endInSeconds)) +
                "\n " +
                "\n§bPour faire appel à cette sanction, rendez-vous sur le discord, merci." +
                "\nhttps://dsc.gg/syzonia" + 
                "\n§r---------------------------");
        	}
               
        		
        		   try {
        	            PreparedStatement sts = MySql.getConnexion().prepareStatement("INSERT INTO bans (player_uuid, end, reason) VALUES (?, ?, ?)");
        	            sts.setString(1, uuid.toString());
        	            sts.setLong(2, getMillisEnd(endInSeconds));
        	            sts.setString(3, reason);
        	            sts.executeUpdate();
        	        } catch (SQLException e) {
        	            e.printStackTrace();
        	        }
        	
        	}
    }

	public static UUID getUUID(String playername) {
		try {
			PreparedStatement stats = MySql.getConnexion().prepareStatement("SELECT uuid_player FROM players WHERE pseudo_player = ?");
			stats.setString(1, playername);
			ResultSet rs = stats.executeQuery();
			
			while(rs.next()) {
				return UUID.fromString(rs.getString("uuid_player"));
			}
			stats.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}

    public void unban(UUID uuid){
        if(!isBanned(uuid)) return;
  
        try { 
            PreparedStatement sts = MySql.getConnexion().prepareStatement("DELETE FROM bans WHERE player_uuid = ?");
            sts.setString(1, uuid.toString());
            sts.executeUpdate();
            sts.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public long getMillisEnd(long endInSeconds) {
    	long endToMillis = endInSeconds * 1000;
	        long end = endToMillis + System.currentTimeMillis();
	 
	        if(endInSeconds == -1) end = -1;
	        
	        return end;
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
 
    public void checkDuration(UUID uuid){
        if(!isBanned(uuid)) return;
 
        if(getEnd(uuid) == -1) return;
 
        if(getEnd(uuid) < System.currentTimeMillis()){
            unban(uuid);
        }
    }
 
    public long getEnd(UUID uuid){
        if(!isBanned(uuid)) return 0;
 
        try {
            PreparedStatement sts = MySql.getConnexion().prepareStatement("SELECT * FROM bans WHERE player_uuid = ?");
            sts.setString(1, uuid.toString());
            ResultSet rs = sts.executeQuery();
            if(rs.next()){
                return rs.getLong("end");
            }
            
            sts.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
 
   
    public String getTimeLeft(UUID uuid){
        if(!isBanned(uuid)) return "§cNon banni";
 
        if(getEnd(uuid) == -1){
            return "§cPermanent";
        }
 
        long tempsRestant = (getEnd(uuid) - System.currentTimeMillis()) / 1000;
        int mois = 0;
        int jours = 0;
        int heures = 0;
        int minutes = 0;
        int secondes = 0;
 
        while(tempsRestant >= TimeUnit.MOIS.getToSecond()){
            mois++;
            tempsRestant -= TimeUnit.MOIS.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.JOUR.getToSecond()){
            jours++;
            tempsRestant -= TimeUnit.JOUR.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.HEURE.getToSecond()){
            heures++;
            tempsRestant -= TimeUnit.HEURE.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.MINUTE.getToSecond()){
            minutes++;
            tempsRestant -= TimeUnit.MINUTE.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.SECONDE.getToSecond()){
            secondes++;
            tempsRestant -= TimeUnit.SECONDE.getToSecond();
        }
 
        return mois + " " + TimeUnit.MOIS.getName() + ", " + jours + " " + TimeUnit.JOUR.getName() + ", " + heures + " " + TimeUnit.HEURE.getName() + ", " + minutes + " " + TimeUnit.MINUTE.getName() + ", " + secondes + " " + TimeUnit.SECONDE.getName();
   
    }
    
    public String getTimeWithoutSQL(UUID uuid, Long End){
        if(End == -1){
            return "§cPermanent";
        }
 
        long tempsRestant = (End - System.currentTimeMillis()) / 1000;
        int mois = 0;
        int jours = 0;
        int heures = 0;
        int minutes = 0;
        int secondes = 0;
 
        while(tempsRestant >= TimeUnit.MOIS.getToSecond()){
            mois++;
            tempsRestant -= TimeUnit.MOIS.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.JOUR.getToSecond()){
            jours++;
            tempsRestant -= TimeUnit.JOUR.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.HEURE.getToSecond()){
            heures++;
            tempsRestant -= TimeUnit.HEURE.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.MINUTE.getToSecond()){
            minutes++;
            tempsRestant -= TimeUnit.MINUTE.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.SECONDE.getToSecond()){
            secondes++;
            tempsRestant -= TimeUnit.SECONDE.getToSecond();
        }
 
        return mois + " " + TimeUnit.MOIS.getName() + ", " + jours + " " + TimeUnit.JOUR.getName() + ", " + heures + " " + TimeUnit.HEURE.getName() + ", " + minutes + " " + TimeUnit.MINUTE.getName() + ", " + secondes + " " + TimeUnit.SECONDE.getName();
   
    }
    
    
    
 
    public String getReason(UUID uuid){
        if(!isBanned(uuid)) return "§cNon banni";
 
        try {
            PreparedStatement sts = MySql.getConnexion().prepareStatement("SELECT * FROM bans WHERE player_uuid=?");
            sts.setString(1, uuid.toString());
            ResultSet rs = sts.executeQuery();
            if(rs.next()){
                return rs.getString("reason");
            }
            sts.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "§cNon banni";
    }
	
}
