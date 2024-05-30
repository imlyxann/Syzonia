package fr.syzonia.bungeedb.mysql;


import java.sql.PreparedStatement;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import fr.syzonia.bungeedb.Main;
import fr.syzonia.bungeedb.utils.TimeUnit;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BanManager {

	List<String> msg = new ArrayList<String>();
	List<ProxiedPlayer> ban = new ArrayList<>(); 
	
	public void ban(UUID uuid, long endInSeconds, String reason, String whoban){
	        if(!isBanned(uuid)) {
	                Main.INSTANCE.database.update("INSERT INTO bans (player_uuid, end, reason) VALUES ('" + uuid + "', '" + getMillisEnd(endInSeconds) + "', '" + reason + "')");
	        }
	    }
	
	
 
	    public void unban(UUID uuid){
	        if(!isBanned(uuid)) return;
	  
	        try { 
	            PreparedStatement sts = DatabaseManager.getConnexion().prepareStatement("DELETE FROM bans WHERE player_uuid = ?");
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
	            PreparedStatement sts = DatabaseManager.getConnexion().prepareStatement("SELECT * FROM bans WHERE player_uuid = ?");
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
	            PreparedStatement sts = DatabaseManager.getConnexion().prepareStatement("SELECT * FROM bans WHERE player_uuid = ?");
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
	            PreparedStatement sts = DatabaseManager.getConnexion().prepareStatement("SELECT * FROM bans WHERE player_uuid=?");
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
