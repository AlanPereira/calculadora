package edu.pucsp.calculadora.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.pucsp.calculadora.iface.IControle;
import edu.pucsp.calculadora.iface.ITela;


public class TelaCalc implements ITela{ 
	private JFrame janela;
	private JPanel painelPrincipal;
	private JTextArea areaTxt;
	private IControle controle;
	
	public TelaCalc(IControle controle){
		this.setControle(controle);
	}
	
	public void iniciar() {  
		preparaJanela();
		preparaPainelPrincipal();
		preparaAreaTexto();
		preparaBotaoCarregar();
		mostraJanela();

	}
	private void preparaJanela() {
		janela = new JFrame("Argentum");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);

	}
	private void preparaAreaTexto() {


		areaTxt = new JTextArea();
		areaTxt.setSize(100, 40);
		areaTxt.setText("0");
		areaTxt.setVisible(true);
		areaTxt.setAutoscrolls(true);

		JScrollPane scroll = new JScrollPane(); 
		scroll.getViewport().add(areaTxt); 

		painelPrincipal.add(scroll);

	}

	private void preparaBotaoCarregar() {

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		};
		JButton[] aux = new JButton[10];
		for(int i =0; i<10;i++){
			aux[i] = new JButton(""+i);
			aux[i].addActionListener(listener);

			painelPrincipal.add(aux[i]);
		}
		JButton botaoSair = new JButton("Sair");
		  botaoSair.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		      System.exit(0);
		    }
		  });
		  painelPrincipal.add(botaoSair);

	}
	private void mostraJanela() {
		janela.pack();
		janela.setSize(400, 250);
		janela.setResizable(false);
		janela.setVisible(true);	

	}
	public static void main(String[] args ) {  
		Locale.setDefault(new Locale("pt", "BR"));
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


