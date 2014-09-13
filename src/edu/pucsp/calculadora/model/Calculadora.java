package edu.pucsp.calculadora.model;

import java.util.ArrayList;


public class Calculadora{

	public String CalcularExp(ArrayList<String> exprP){ 

		int n = exprP.size();
		ArrayList<String> pilha = new ArrayList<String>();
		for(int i =0; i<n; i++){
			if(verfOperador(exprP.get(i), "+-*/^")){
				double num2, num1;
				num2 = Double.parseDouble(pilha.remove(pilha.size()-1));
				if(pilha.size()<1){
					num1 = 0.0;
				}else
					num1 = Double.parseDouble(pilha.remove(pilha.size()-1));
				switch(exprP.get(i).charAt(0)){
				case '+':pilha.add(num1+num2+"");break;
				case '-':
					System.out.println(pilha.size()+":::::"+num1+" - "+num2+"= ");
					//System.out.println(exprP.get(i+2));
					if((exprP.size()>i+2) && (exprP.get(i+2).equals("-")))
						pilha.add(-num1-num2+"");
					else
						pilha.add(num1-num2+"");
					
					System.out.println(pilha.get(pilha.size()-1));
					break;
				case '*':pilha.add(num1*num2+"");break;
				case '/':

					pilha.add(num1/num2+"");

					break;//Atenção

				case '^':pilha.add(Math.pow(num1, num2)+"");break;//Atenção
				}
			}else
				pilha.add(exprP.get(i));
		}
		String result = pilha.remove(0);


		return result;
	}


	private boolean verfOperador(String op, String txt){
		String opr [] = txt.split("");
		boolean ok = false;
		for(int i = 1; i<opr.length;i++){
			if(opr[i].equals(op)){
				ok = true;
				break;
			}
		}
		return ok;
	}
}