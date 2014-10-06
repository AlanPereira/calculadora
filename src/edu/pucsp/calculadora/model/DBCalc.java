package edu.pucsp.calculadora.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.pucsp.calculadora.iface.ILog;
import edu.pucsp.calculadora.jdbc.ConnectionFactory;

public class DBCalc implements ILog{

	@Override
	public boolean gravarDados(String txt) {
		String url = "jdbc:mysql://localhost:3306/";
		String db = "db_calc";

		Connection con = new ConnectionFactory().getConnection(url);
		Statement st;

		try {
			st = con.createStatement();
			st.execute("CREATE DATABASE IF NOT EXISTS "+db);
			
			if(createTable(st, db)){
				System.out.println("Teste ok");
			}
			
			
			st.close();
			con.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	private boolean createTable(Statement st, String db) {
		
		boolean ok = true;
		try{ 
			String SQL = (db+" CREATE TABLE calc " +
			"(Nome VARCHAR(60), Idade INT(2))");
			st.execute(SQL);
			
			
		}catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			ok = false;
		}catch(Exception e) {
			ok = false;
			System.out.println("Exception: " + e.getMessage());
		}      
		
		
		
		return ok;
	}

	@Override
	public String[] lerDados() {
		// TODO Auto-generated method stub
		return null;
	}	

}
