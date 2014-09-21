package edu.pucsp.calculadora.view;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.pucsp.calculadora.iface.LogFile;

public class LogFileBin implements LogFile {

	private String result;
	@Override
	public boolean gravarDados(String txt) {
		try {
			File arquivo = new File("/.teste.txt");
			if(!arquivo.exists());
				arquivo.createNewFile();
			FileOutputStream arq = new FileOutputStream(arquivo, true);
		
			DataOutputStream dos = new DataOutputStream(arq);
			//ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("./teste2.txt"));
		String [] bin = converteBin(txt);
		for(String aux:bin){
			dos.writeChars(aux);
		}
		
		//Dados n = new Dados();
		//n.setExpressao(txt);
		//dos.writeObject(n);
		dos.close();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//dos.close();
		
		return false;
	}

	private String[] converteBin(String txt){
		String texto1 = txt;  
	    byte[] bytes = texto1.getBytes();  
	    String[] binarios = new String[bytes.length];  
	    System.out.println(texto1);  

	    String txt2 = "";
	    // jogando prum array de string  
	    for (int i=0; i < bytes.length; i++) {  
	        binarios[i] = Integer.toBinaryString(bytes[i]); 
	        txt2 += Integer.toBinaryString(bytes[i]); 
	        System.out.println(bytes[i] + " -> " + binarios[i]);  
	    }  

	    StringBuffer texto2 = new StringBuffer();   
	    // agora a vorta  
	    
	    for (int i=0; i < binarios.length; i++) {  
	        texto2.append((char)Integer.parseInt(binarios[i],2));
	        
	    }  
	    System.out.println(texto2.toString());
	    
	    return binarios;
	}
	//private String convertTxt(String bin){
		//StringBuffer texto2 = new StringBuffer();   
	    // agora a vorta  
	    
	   // for (int i=0; i < binarios.length; i++) {  
	     //   texto2.append((char)Integer.parseInt(binarios[i],2));
	        
	   // }  
	    //System.out.println(texto2.toString());
	//}


	@SuppressWarnings({ "deprecation", "resource" })
	public void readData() throws IOException{
		FileInputStream file= new FileInputStream("./teste.txt"); 
		DataInputStream arq = new DataInputStream(file);  
		String txt = arq.readLine();
		while(txt != null)
			txt = arq.readLine();
	}
		

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}