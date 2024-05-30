package fr.syzonia.syzodb.mysql;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;

import fr.syzonia.syzodb.rank.Rank;


public class MySql {

	private String urlBase;
	private String host;
	private String dataBase;
	private String userName;
	private String password;
	public static Connection connection;
 
	public MySql(String urlBase, String host, String dataBase, String userName, String password) {
		this.urlBase = urlBase;
		this.host = host;
		this.dataBase = dataBase;
		this.userName = userName;
		this.password = password;
	}
 
	public static Connection getConnexion() {
		return connection;
	}
 
	public void createAccount(UUID uuid) {
		if(!hasAccount(uuid)) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players (uuid_player, pseudo_player, coins, grade, grade_name, LastMessageInChat, rewards_found, use_pets, use_particules, use_mount, use_gadget, use_chapeaux, use_pull, use_pantalon, use_chaussure, HostTicket) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				preparedStatement.setString(1, uuid.toString());
				preparedStatement.setString(2, Bukkit.getPlayer(uuid).getName());
				preparedStatement.setInt(3, 100);
				preparedStatement.setDouble(4, 0);
				preparedStatement.setString(5, Rank.PowerToRank(0).getName());
				preparedStatement.setString(6, "");
				preparedStatement.setInt(7, 0);
				preparedStatement.setInt(8, 0);
				preparedStatement.setInt(9, 0);
				preparedStatement.setInt(10, 0);
				preparedStatement.setInt(11, 0);
				preparedStatement.setInt(12, 0);
				preparedStatement.setInt(13, 0);
				preparedStatement.setInt(14, 0);
				preparedStatement.setInt(15, 0);
				preparedStatement.setLong(16, 0);
				preparedStatement.execute();
				preparedStatement.close();
 
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		if(!hasPrefAccount(uuid)) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players_data (uuid_player, msg, CanSeePlayer, Legend_Symbol) VALUES (?, ?, ?, ?)");
				preparedStatement.setString(1, uuid.toString());
				preparedStatement.setInt(2, 0);
				preparedStatement.setBoolean(3, false);
				preparedStatement.setInt(4, 0);
				preparedStatement.execute();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
 
	public boolean hasAccount(UUID uuid) {
		try {
		    PreparedStatement preparedStatement = connection.prepareStatement("SELECT coins FROM players WHERE uuid_player = ?");
		    preparedStatement.setString(1, uuid.toString());
		    ResultSet rs = preparedStatement.executeQuery();
 
		    while(rs.next()) {
		    	return true;
		    }
		    return false;
 
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean hasPrefAccount(UUID uuid) {
		try {
		    PreparedStatement preparedStatement = connection.prepareStatement("SELECT msg FROM players_data WHERE uuid_player = ?");
		    preparedStatement.setString(1, uuid.toString());
		    ResultSet rs = preparedStatement.executeQuery();
 
		    while(rs.next()) {
		    	return true;
		    }
		    return false;
 
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
    public boolean isBanned(UUID uuid){
        try {
            PreparedStatement sts = MySql.getConnexion().prepareStatement("SELECT * FROM bans WHERE player_uuid=?");
            sts.setString(1, uuid.toString());
            ResultSet rs = sts.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public void setPseudo(UUID uuid, String s) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET pseudo_player = ? WHERE uuid_player = ?");
				preparedStatement.setString(1, s);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setRankName(UUID uuid, String rankname) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players SET grade_name = ? WHERE uuid_player = ?");
				preparedStatement.setString(1, rankname);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getRankName(UUID uuid) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT grade_name FROM players WHERE uuid_player = ?");
				preparedStatement.setString(1, uuid.toString());
				ResultSet rs = preparedStatement.executeQuery();
				String rank = "";
						while (rs.next()) {
							rank = rs.getString("grade_name");
						}
						preparedStatement.close();
				return rank;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "";
		}
 
	public void setCanseePlayer(UUID uuid, int i) {
		try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("UPDATE players_data SET CanSeePlayer = ? WHERE uuid_player = ?");
				preparedStatement.setInt(1, i);
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.executeUpdate();
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getSeePlayer(UUID uuid) {
			try {
				PreparedStatement preparedStatement = MySql.getConnexion().prepareStatement("SELECT CanSeePlayer FROM players_data WHERE uuid_player = ?");
				preparedStatement.setString(1, uuid.toString());
				ResultSet rs = preparedStatement.executeQuery();
				int yes = 0;
						while (rs.next()) {
							yes = rs.getInt("CanseePlayer");
						}
						preparedStatement.close();
				return yes;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
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
	
	public static String getPseudo(UUID uuid) {
		try {
			PreparedStatement stats = MySql.getConnexion().prepareStatement("SELECT pseudo_player FROM players WHERE uuid_player = ?");
			stats.setString(1, uuid.toString());
			ResultSet rs = stats.executeQuery();
			
			while(rs.next()) {
				return rs.getString("pseudo_player");
			}
			stats.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void connexion() {
		if(!isOnline()) {
			try {
				connection = DriverManager.getConnection(this.urlBase + this.host + "/" + this.dataBase + "?characterEncoding=utf8", this.userName, this.password);
				System.out.println("[Syzonia-db] Connexion > Succes");
				return;
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	

 
	public void deconnexion() {
		if(isOnline()) {
			try {
				connection.close();
				System.out.println("[Syzonia-db] Deconnexion > Succes");
				return;
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
 
	public boolean isOnline() {
		try {
			if((connection == null) || (connection.isClosed())) {
				return false;
			}
			return true;
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getResult(Class<T> classe, String query, String table, Object ... args) 
	{
		connexion();
		try {
			PreparedStatement stat = connection.prepareStatement(query);
			for(int  i = 0; i < args.length; i++) stat.setObject(i + 1, args[1]);
			ResultSet rs = stat.executeQuery();
			if(classe.getName().equals(ResultSet.class.getName())) return (T) rs;
			while (rs.next()) return (T) rs.getObject(table);
			
		} catch (Exception e) { e.printStackTrace(); } 
		return null;
	}
		
		public void update(String query, Object... args) 
		{
			this.connexion();
			try {
				PreparedStatement stat = connection.prepareStatement(query);
				for(int i = 0; i < args.length; i++) stat.setObject(i + 1, args[1]);
				stat.executeUpdate();
			} catch (SQLException e) { e.printStackTrace(); }
		}
}
