package fr.syzonia.syzodb.mysql.mysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.syzonia.syzodb.mysql.MySql;

public class SQLRequest {

	public static void Request(String sql) {
		try {
			PreparedStatement stat = MySql.getConnexion().prepareStatement(sql);
			stat.execute();
			stat.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Update(String sql) {
		try {
			PreparedStatement stat = MySql.getConnexion().prepareStatement(sql);
			stat.executeUpdate();
			stat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
