import java.io.*;
import javax.swing.JOptionPane;

public class TesteOut0 {
	public static void main(String[] args) {

        	String arquivo = JOptionPane.showInputDialog("Arquivo: ");

        	DataOutputStream dos = null;
        	FileOutputStream fos = null;

        	try {
            		fos = new FileOutputStream(arquivo);
            		dos = new DataOutputStream(fos);

        	} catch(IOException ex) {
            		System.out.println("Nao conseguiu abrir o arquivo: " + arquivo);
            		return;
        	} catch(Exception ex) {
            		System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
           		 return;
        	}

        	int a = Integer.parseInt(JOptionPane.showInputDialog("Forneca um inteiro: "));

        	double b = Double.parseDouble(JOptionPane.showInputDialog("Forneca um double: "));

        	String s = JOptionPane.showInputDialog("Forneca uma String: ");


        	try {
            		dos.writeInt(a);
	    		System.out.println("Gravou: " + a + " no disco.");

            		dos.writeDouble(b);
	    		System.out.println("Gravou: " + b + " no disco.");

            		dos.writeUTF(s);
	    		System.out.println("Gravou: " + s + " no disco.");

        	} catch(IOException ex) {
            		System.out.println("Nao conseguiu escrever no arquivo: " + arquivo);
            		return;
        	} catch(Exception ex) {
            		System.out.println("Erro inesperado ao tentar ler o arquivo: " + arquivo);
            		return;
        	} finally {
            		try {
                		dos.close();
            		} catch(Exception ex) {
				// Nao faz nada!
	    		}
            		try {
                		fos.close();
            		} catch(Exception ex) {
				// Nao faz nada!
	    		}
        	}
   	}
}
