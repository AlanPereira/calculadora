package edu.pucsp.calculadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.pucsp.calculadora.iface.IControle;
import edu.pucsp.calculadora.iface.ITela;


public class Visual extends JFrame implements ActionListener, ITela{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5108354603003336883L;
	JTextField txt;
	IControle ctr;
	public Visual(IControle ctr) {
		this.ctr = ctr;
		
		this.setSize(200,300);
		JPanel panelNumeros = new JPanel();

		//Monta grid e Jbuttons
	    GridBagConstraints c = new GridBagConstraints();
		panelNumeros.setLayout(new GridBagLayout());
		JButton btn;
		txt =  new JTextField();
		txt.setEditable(false);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = 4;
	    panelNumeros.add(txt, c);
	    
	    for(int cont = 0; cont <= 7; cont++)
	    {
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.0;
			c.weighty = 1.0;
	    	c.gridx = cont % 4;
		    c.gridy = cont / 4 + 1;
		    c.gridwidth = 1;
		    btn =  new JButton();
		    btn.addActionListener(this);
		    
		    switch (cont) {
			case 0:
				btn.setText("+");
				break;
			case 1:
				btn.setText("-");
				break;
			case 2:
				btn.setText("*");
				break;
			case 3:
				btn.setText("/");
				break;
			case 4:
				btn.setText("(");
				break;
			case 5:
				btn.setText(")");
				break;
			case 6:
				btn.setText("C");
				break;
			case 7:
				btn.setText("<<");
				break;
			default:
				break;
			}
		    
		    panelNumeros.add(btn, c);
	    }

	    for(int cont = 0; cont <= 11; cont++)
	    {
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.0;
			c.weighty = 1.0;
	    	c.gridx = cont % 4;
		    c.gridy = cont / 4 + 3;
		    c.gridwidth = 1;
		    
	    	btn =  new JButton();
		    btn.addActionListener(this);
		    
		    if(cont < 10)
		    {
				btn.setText(""+cont);
		    }
		    else if(cont == 10)
		    {
				btn.setText(".");
		    }
		    else if(cont == 11)
		    {
				btn.setText("=");
		    }
		    
		    panelNumeros.add(btn, c);
	    }
	    
	    //Adiciona o grid o grd ao panel e depois a janela.
		this.setLayout(new BorderLayout());
	    panelNumeros.setBackground(Color.GRAY);
		this.add(panelNumeros);

		this.setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent event) {
		
		 String textButton = ((JButton) event.getSource()).getText();
		 
		 switch (textButton) {
		 case "C":
			 txt.setText("");
			 break;
		 case "<<":
			 if(txt.getText().length() > 0)txt.setText(txt.getText().substring(0,txt.getText().length() -1));
			 break;
		 case "=":
			 txt.setText(ctr.calcular(txt.getText()));
			break;
		default:
			txt.setText(txt.getText() + textButton);
			break;
		}
	}

	@Override
	public void iniciar() {
		this.setVisible(true);
		
	}
}
