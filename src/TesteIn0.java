import java.io.*;
import javax.swing.JOptionPane;
public class TesteIn0 {
	public static void main(String[] args) {

      	String arquivo = JOptionPane.showInputDialog("Arquivo: ");

        DataInputStream dis = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(arquivo);
            dis = new DataInputStream(fis);
        } catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: " + arquivo);
            return;
        } catch(IOException ex) {
            System.out.println("Nao conseguiu abrir o arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            return;
        }

        try {
            int a = dis.readInt();
            System.out.println("Leu o inteiro:" + a + " do disco");

            double b = dis.readDouble();
            System.out.println("Leu o double:" + b + " do disco");

            String s = dis.readUTF();
            System.out.println("Leu o String:" + s + " do disco");

        } catch(EOFException ex) {
            System.out.println("Atingiu prematuramente o final do arquivo: " + arquivo);
            return;
        } catch(IOException ex) {
            System.out.println("Nao conseguiu ler do arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar ler o arquivo: " + arquivo);
            return;
        } finally {
            try {
                dis.close();
            } catch(Exception ex) {
		// Nao faz nada !
	    }
            try {
                fis.close();
            } catch(Exception ex) {
		// Nao faz nada !
	    }
        }
   	}
}
