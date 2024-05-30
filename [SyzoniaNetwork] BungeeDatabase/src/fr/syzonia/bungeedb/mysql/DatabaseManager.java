package fr.syzonia.bungeedb.mysql;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.syzonia.bungeedb.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;

public class DatabaseManager {

	private String urlBase;
	private String host;
	private String dataBase;
	private String userName;
	private String password;
	public static Connection connection;
 
	public DatabaseManager(String urlBase, String host, String dataBase, String userName, String password) {
		this.urlBase = urlBase;
		this.host = host;
		this.dataBase = dataBase;
		this.userName = userName;
		this.password = password;
	}
 
	public static Connection getConnexion() {
		return connection;
	}
 
	public void createFriendsAllowOnJoin(UUID uuid) {
		if(!hasFriendsAllow(uuid)) {
			try {
				PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("INSERT INTO player_friends_allow (uuid_player, pseudo_player, friends_allow) VALUES (?, ?, ?)");
				stat.setString(1, uuid.toString());
				stat.setString(2, ProxyServer.getInstance().getPlayer(uuid).getName());
				stat.setInt(3, 1);
				stat.execute();
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	public void update(String query) {
		if (isOnline()) {
			BungeeCord.getInstance().getScheduler().runAsync(Main.INSTANCE, new Runnable() {
				@Override
				public void run() {
					try {
						PreparedStatement pst = connection.prepareStatement(query);
						pst.execute();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	public boolean hasFriendsAllow(UUID uuid) {
		try {
		    PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT pseudo_player FROM player_friends_allow WHERE uuid_player = ?");
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

	public static UUID getUUID(String playername) {
		try {
			PreparedStatement stats = DatabaseManager.getConnexion().prepareStatement("SELECT uuid_player FROM players WHERE pseudo_player = ?");
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
			PreparedStatement stats = DatabaseManager.getConnexion().prepareStatement("SELECT pseudo_player FROM players WHERE uuid_player = ?");
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
	
	public static double getPlayerRank(UUID uuid) {
		try {
			
			PreparedStatement preparedStatement = DatabaseManager.getConnexion().prepareStatement("SELECT grade FROM players WHERE uuid_player = ?");
			preparedStatement.setString(1, uuid.toString());
			double power = 0;
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				power = rs.getInt("grade");
			}
			preparedStatement.close();
			
			return power;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void connexion() {
		if(!isOnline()) {
			try {
				connection = DriverManager.getConnection(this.urlBase + this.host + "/" + this.dataBase + "?characterEncoding=utf8", this.userName, this.password);
				System.out.println("[DataBase] Connexion Réussi");
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
				System.out.println("[DataBase] Déconnexion Réussi");
				return;
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
 
	public static boolean isOnline() {
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
	
}
