package edu.pucsp.calculadora.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.pucsp.calculadora.iface.ILog;
import edu.pucsp.calculadora.jdbc.ConnectionFactory;

public class DBCalc implements ILog{

	@Override
	public boolean gravarDados(String txt) {
		String db = "db_calc";
		String url = "jdbc:mysql://localhost:3306/"+db;
		Connection con = new ConnectionFactory().getConnection(url);
		Statement st;

		try {
			
			String data = (new SimpleDateFormat("yyyy/MM/dd")).format(new Date());
			String hora = (new SimpleDateFormat("HH:mm:ss")).format(new Date());
			st = con.createStatement();
			
			String sql = "INSERT INTO LogCalc (Expressao) VALUES('"+txt+"')";
			
			
			
			st.execute(sql);
			
			
			
			st.close();
			con.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	
	@Override
	public String[] lerDados() {
		// TODO Auto-generated method stub
		return null;
	}	

}
