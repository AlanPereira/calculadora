package edu.pucsp.calculadora.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.pucsp.calculadora.iface.ILog;

public class LogFileBin implements ILog {

	@Override
	public boolean gravarDados(String txt) {
		try {
			File arquivo = new File("LogBin.bin");
			if(!arquivo.exists())
				arquivo.createNewFile();

			OutputStream os = new FileOutputStream(arquivo, true);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			txt = ((new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss|")).format(new Date())) + txt;
			txt = converteBin(txt);
			bw.write(txt);
			bw.newLine();
			bw.close();
			osw.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	private String converteBin(String texto){
		byte[] bytes = texto.getBytes();  
		String[] binarios = new String[bytes.length];  
		//System.out.println(texto);  

		String txt = "";
		// jogando prum array de string  
		for (int i=0; i < bytes.length; i++) {  
			binarios[i] = Integer.toBinaryString(bytes[i]); 
			txt = txt + Integer.toBinaryString(bytes[i]);
			txt = txt+" "; 
			//System.out.println(bytes[i] + " -> " + binarios[i]);  
		}
			//System.out.println(txt);
		return txt;
	}
	
	private String convertTxt(String bin[]){
		StringBuffer texto2 = new StringBuffer();   
		//agora a vorta  

		for (int i=0; i < bin.length; i++) {  
			texto2.append((char)Integer.parseInt(bin[i],2));
		}  
		//System.out.println(texto2.toString());

		return texto2.toString();
	}

	@Override
	public String[] lerDados() {

		ArrayList<String> list = new ArrayList<String>();
		String [] dados = null;
		try{

			InputStream is = new FileInputStream("logBin.bin");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String aux = br.readLine();

			while (aux!= null) {
				list.add(convertTxt(aux.split(" ")));
				aux = br.readLine();
			}

			br.close();
		}catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
		}
		dados = new String[list.size()];

		int i =0;

		while(!list.isEmpty())
			dados[i++] = list.remove(0);
		list = null;
		//System.out.println();
		return dados;
	}
}