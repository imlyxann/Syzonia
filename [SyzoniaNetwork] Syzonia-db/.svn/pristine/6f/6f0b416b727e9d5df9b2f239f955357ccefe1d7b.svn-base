package fr.syzonia.syzodb.mysql.SQL;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.syzonia.syzodb.mysql.MySql;

public class SQL {
	
	public static Object SQL_Receive(String query, String table) {
		Object obj = null;
		try {
			
			Statement sql = MySql.getConnexion().createStatement();
			ResultSet rs = sql.executeQuery(query);
	
			while(rs.next()) {
				obj = rs.getObject(table);
			}
			
			sql.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return obj;
	}


	public static List<Object> getList(String query, String table) {
		List<Object> obj = new ArrayList<Object>();
		try {
			
			Statement sql = MySql.getConnexion().createStatement();
			ResultSet rs = sql.executeQuery(query);
	
			while(rs.next()) {
				obj.add(rs.getObject(table));	
			}
	
			sql.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return obj;
	}


	public static void SQL_Update(String query) {
		try {

			Statement sql = MySql.connection.createStatement();
			sql.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}
	
	public static String Statement(String string) {
		try {
	
			PreparedStatement sql = MySql.connection.prepareStatement(string);
			sql.executeUpdate();
			sql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public static Object query(String string, String column) {
		Object obj = null;
		try {
			
			PreparedStatement stat = MySql.connection.prepareStatement(string);
			ResultSet set = stat.executeQuery();
			
			while (set.next()) {
				obj = set.getObject(column);
			}
			
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}

