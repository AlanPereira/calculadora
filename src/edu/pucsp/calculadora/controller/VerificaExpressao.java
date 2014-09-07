package edu.pucsp.calculadora.controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class VerificaExpressao {

	//delimitadores 
	private String op;

	public VerificaExpressao(){
		this.op = "+-/*()";
	}

	public boolean validaExpressao(String exp){
		boolean ok = true;
		if(verificaFormat(exp)){
			ArrayList<String> list = separaExpressao(exp);
			int n = list.size();
			int cont = 0,  i = 0;
			String aux = "";	
			while (ok && i < n){
				aux = list.get(i);
				i++;
				
				System.out.println(i+" "+aux+" size: "+list.size());
				if(verfOperador(aux.charAt(0))){
					/*if(verfOperador(list.get(i).charAt(0), "+*-/") ){
						if(i+1< list.size()){
							if(verfOperador(list.get(i+1).charAt(0), "+*-/"))
								ok = false;
						}else
							ok= false;
					}*/

					if(aux.equals("(")){
						if(i+1< list.size())
							if(verfOperador(list.get(i+1).charAt(0)))
								ok = false;
						cont++;
					}
					else if(aux.equals(")")){
						if(verfOperador(list.get(i-1).charAt(0)))
							ok = false;
						if(cont>0)
							cont--;
						else
							ok = false;
					}
				}
			}
			if(cont!=0)
				ok = false;
		}else
			ok = false;
		return ok;

	}

	private ArrayList<String> separaExpressao(String expr){

		ArrayList<String> exp = new ArrayList<String>();

		int n = 0;
		String numb = "";

		while(n < expr.length()){

			if(verfOperador(expr.charAt(n))){
				exp.add(numb);
				exp.add(expr.charAt(n)+"");
				numb = "";
			}else
				numb = numb + expr.charAt(n);
			n++;
		}
		exp.add(numb);
		for(int i = 0; i<exp.size();i++){
			System.out.println(exp.get(i));
		}
		System.out.println("Passou - separa Expressão");
		return exp;
	}

	private boolean verificaFormat(String exp){
		boolean ok = true;
		String delim = op;
		StringTokenizer st = new StringTokenizer(exp, delim);
		try{
			while (st.hasMoreElements()) {
				double n = Double.parseDouble(st.nextToken());
			}
		}catch (NumberFormatException e) {
			System.out.println("Passou - verificaFormat pelo catch");
			return false;

		}
		System.out.println("Passou - verificaFormat");
		return ok;
	}

	private boolean verfOperador(Character carc){
		String opr = this.op;
		boolean ok = false;
		for(int i = 0; i<opr.length();i++){
			if(opr.charAt(i) == carc){
				ok = true;
				break;
			}
		}
		return ok;
	}

	/*private boolean verfOperador(Character op, String txt){
		String opr = txt;
		boolean ok = false;
		for(int i = 0; i<opr.length();i++){
			if(opr.charAt(i) == op){
				ok = true;
				break;
			}
		}
		return ok;
	}*/
}


