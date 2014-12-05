package edu.pucsp.calculadora.cliente;
/**
 * Cliente de chat (utilizando socket)
 * @author LP4 - PUCSP (2010)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
public class Cliente extends Thread {
	public String calcular(String expressao) {
		String linha ="";
		try {

			@SuppressWarnings("resource")
			Socket conexao = new Socket("127.0.0.1", 2222);
			PrintStream saida = new
					PrintStream(conexao.getOutputStream());

			saida.println(expressao);

			BufferedReader entrada = new BufferedReader
					(new InputStreamReader(conexao.getInputStream()));
			
			linha = entrada.readLine();

			if (linha == null) {
				linha = "Conexão encerrada!";

			}

		}
		catch (IOException e) {
			// caso ocorra alguma exceção de E/S, mostre qual foi.
			linha = "Erro de conexão";
		}
		return linha;
	}
}