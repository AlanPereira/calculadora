package edu.pucsp.calculadora.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.pucsp.calculadora.iface.ILog;

public class LogFileText implements ILog{
	public boolean gravarDados(String txt){
		boolean ok = true;
		File arquivo = new File("LogTxt.txt");

		try {

			if (!arquivo.exists()) {
				//cria um arquivo (vazio)
				arquivo.createNewFile();
			}

			//caso seja um diretorio, e possivel listar seus arquivos e diretorios
			//File[] arquivos = arquivo.listFiles();

			//escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, true);

			BufferedWriter bw = new BufferedWriter(fw);
			txt = ((new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss|")).format(new Date())) + txt;
			bw.write(txt);

			bw.newLine();

			bw.close();
			fw.close();
		}catch(IOException e){
			ok = false;
		}
		return ok;
	}

	public String[] lerDados(){
		
		ArrayList<String> list = new ArrayList<String>();
		String [] dados = null;
		try { 
			FileReader arq = new FileReader("LogTxt.txt"); 
			BufferedReader lerArq = new BufferedReader(arq); 
			
			int i = 0;
			list.add(lerArq.readLine()); // lê a primeira linha 
			
			// a variável "linha" recebe o valor "null" quando o processo de repetição atingir o final do arquivo texto 
			while (list.get(list.size()-1)!= null) { 
				System.out.printf("%s\n", list.get(i)); 
				i++;
				list.add(lerArq.readLine()); 
				// lê da segunda até a última linha 
			}
			arq.close(); 
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
		} 
		dados = new String[list.size()];
		
		int i =0;
		
		while(!list.isEmpty())
			dados[i++] = list.remove(0);
		list = null;
		System.out.println();
		return dados;

	}
}

