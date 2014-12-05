package edu.pucsp.calculadora.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;



import edu.pucsp.calculadora.controller.Controler;


public class Servidor extends Thread{
	// socket deste cliente
	private Socket conexao;

	
	public Servidor(){
		//
	}
	
	public Servidor(Socket con){
		this.conexao = con;
	}
	
	
	@SuppressWarnings("resource")
	public void iniciar(){
		try {
			// criando um socket que fica escutando a porta 2222.
			ServerSocket s = new ServerSocket(2222);
			// Loop principal.
			while (true) {

				System.out.print("Esperando alguem se conectar...");
				Socket conexao = s.accept();
				System.out.println(" Conectou!");
				// cria uma nova thread para tratar essa conex�o
				 new Servidor(conexao).start();
				
				// voltando ao loop, esperando mais algu�m se conectar.
			}
		}
		catch (IOException e) {
			// imprime exception.
			System.out.println("IOException: " + e);
		}
	}

	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new
					InputStreamReader(conexao.getInputStream()));
			PrintStream saida = new 
					PrintStream(conexao.getOutputStream());
			// primeiramente, espera-se pelo nome do cliente
			String expr = entrada.readLine();
			
			String result = (new Controler()).calcular(expr);
			
			System.out.println("Expressão: "+expr+" Resultado: "+result);
			saida.println(result);
			
			conexao.close();
			
		}
		catch (IOException e) {
			// Caso ocorra alguma excessao de E/S, mostre qual foi.
			System.out.println("IOException: " + e);
		}
	}
}
