package edu.pucsp.calculadora.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFileText {
	public boolean gravarDados(String txt){
		boolean ok = true;
		File arquivo = new File("Logtexto.txt");

		try {

			if (!arquivo.exists()) {
				//cria um arquivo (vazio)
				arquivo.createNewFile();
			}

			//caso seja um diretório, é possível listar seus arquivos e diretórios
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
}
