package fr.syzonia.syzowolfdb.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SyzoWolfDatabaseManager {

	private String urlBase;
	private String host;
	private String dataBase;
	private String userName;
	private String password;
	public static Connection connection;
 
	public SyzoWolfDatabaseManager(String urlBase, String host, String dataBase, String userName, String password) {
		this.urlBase = urlBase;
		this.host = host;
		this.dataBase = dataBase;
		this.userName = userName;
		this.password = password;
	}
 
	public static Connection getConnexion() {
		return connection;
	}
	
	public void connexion() {
		if(!isOnline()) {
			try {
				connection = DriverManager.getConnection(this.urlBase + this.host + "/" + this.dataBase + "?characterEncoding=utf8", this.userName, this.password);
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
	
}
