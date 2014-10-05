package edu.pucsp.calculadora.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.pucsp.calculadora.iface.ILog;

public class DBCalc implements ILog{

	@Override
	public boolean gravarDados(String txt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] lerDados() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void conexao() throws SQLException{
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/mysql");
				System.out.println("Conectado!");
				conexao.close();
	}
	
	
	
}
