package edu.pucsp.calculadora.view;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.pucsp.calculadora.iface.IControle;
import edu.pucsp.calculadora.iface.ITela;


public class TelaCalc extends JFrame implements ITela{ 
	private JTextField txt1;
	private IControle controle;

	public TelaCalc(IControle controle){
		this.setControle(controle);
	}

	public void iniciar() {  
		preparaAreaTexto();
		preparaBotaoCarregar();
		mostraJanela();
	}	

	private void preparaAreaTexto() {
		txt1 = new JTextField();
		txt1.setLocation(10, 5);
		txt1.setText("0");
		txt1.setSize(280, 30);
		txt1.setBorder(null);
		txt1.setHorizontalAlignment(JTextField.RIGHT);
		txt1.setCaretPosition(1);
		add(txt1);

	}

	private void preparaBotaoCarregar() {

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		};
		int k = 9;
		JButton[] aux = new JButton[9];
		for(int j= 0; j<3;j++)
			for(int i =0; i<3;i++){
				aux[i] = new JButton();
				String t = k--+"";
				aux[i].setText(t);
				aux[i].addActionListener(listener);
				aux[i].setSize(35,30);
				aux[i].setLocation(10+40*i,40+35*j);
				add(aux[i]);
			}
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(botaoSair);

	}

	private void mostraJanela() {
		//pack();
		setSize(310, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setVisible(true);	


	}
	public static void main(String[] args ) {  
		//Locale.setDefault(new Locale("pt", "BR"));
		TelaCalc exe = new TelaCalc(null);  
		exe.iniciar();     
	}

	public IControle getControle() {
		return controle;
	}

	public void setControle(IControle controle) {
		this.controle = controle;
	}  
}  


