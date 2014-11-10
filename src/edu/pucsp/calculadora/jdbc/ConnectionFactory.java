package edu.pucsp.calculadora.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection(String url) {
		try {
			String user, password; 
			user="root";password="";

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection(url, user, password);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}	
}