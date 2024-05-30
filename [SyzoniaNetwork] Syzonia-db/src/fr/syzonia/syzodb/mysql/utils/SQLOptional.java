package fr.syzonia.syzodb.mysql.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

import fr.syzonia.syzodb.mysql.MySql;

public class SQLOptional {

	public static Optional<String> SQL_ReceiveOptional(String query, String columnName, Object... params) {
		  try (Connection connection = MySql.getConnexion();
		       PreparedStatement statement = connection.prepareStatement(query)) {
		    for (int i = 0; i < params.length; i++) {
		      statement.setObject(i + 1, params[i]);
		    }
		    try (ResultSet resultSet = statement.executeQuery()) {
		      if (resultSet.next()) {
		        return Optional.ofNullable(resultSet.getString(columnName));
		      }
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  return Optional.empty();
	}
	
	public static HashMap<String, Object> SQL_ReceiveHashMap(String query, String[] columnNames, Object... params) {
		  try (Connection connection = MySql.getConnexion();
		       PreparedStatement statement = connection.prepareStatement(query)) {
		    for (int i = 0; i < params.length; i++) {
		      statement.setObject(i + 1, params[i]);
		    }
		    try (ResultSet resultSet = statement.executeQuery()) {
		      if (resultSet.next()) {
		        HashMap<String, Object> results = new HashMap<>();
		        for (int i = 0; i < columnNames.length; i++) {
		          results.put(columnNames[i], resultSet.getObject(i + 1));
		        }
		        return results;
		      }
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  return null;
	}
	
}
