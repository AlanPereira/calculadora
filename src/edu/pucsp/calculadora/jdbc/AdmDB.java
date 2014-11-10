package edu.pucsp.calculadora.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AdmDB {

	public static void main(String[] args) {
		(new AdmDB()).createDB();

	}

	private void createDB() {

		String url = "jdbc:mysql://localhost:3306/";
		String db = "db_calc";

		Connection con = new ConnectionFactory().getConnection(url);
		Statement st;

		try {
			st = con.createStatement();
			st.execute("CREATE DATABASE IF NOT EXISTS "+db);
			st.execute("USE "+db);
			st.execute(" create table LogCalc ("
					+ "	id BIGINT NOT NULL AUTO_INCREMENT,"
					+ "Expressao VARCHAR(255),"
					+ "Data DATE,"
					+ "Hora TIME,"
					+ "primary key (id));");

			st.close();
			con.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
