package edu.pucsp.calculadora.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection(String url) {
		try {
			String user, password; 
			user="root";password="";
			return DriverManager.getConnection(
					url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}