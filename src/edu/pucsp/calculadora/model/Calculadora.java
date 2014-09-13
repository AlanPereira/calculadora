package edu.pucsp.calculadora.model;

import java.util.ArrayList;


public class Calculadora{
	
	private float res;
	
	public float getRes() {
		return res;
	}

	public void setRes(float res) {
		this.res = res;
	}

	public String CalcularExp(ArrayList<String> exprP){ 
		
		int n = exprP.size();
		ArrayList<String> pilha = new ArrayList<String>();
		for(int i =0; i<n; i++){
			if(verfOperador(exprP.get(i), "+-*/^")){
				double num2 = Double.parseDouble(pilha.remove(pilha.size()-1));
				double num1 = Double.parseDouble(pilha.remove(pilha.size()-1));
				switch(exprP.get(i).charAt(0)){
				case '+':pilha.add(num1+num2+"");break;
				case '-':pilha.add(num1-num2+"");break;//Atenção
				case '*':pilha.add(num1*num2+"");break;
				case '/':pilha.add(num1/num2+"");break;//Atenção
				case '^':pilha.add(Math.pow(num1, num2)+"");break;//Atenção
				}
			}else
				pilha.add(exprP.get(i));
		}
		String result = pilha.remove(0);
		
		
		return result;
	}

//	private void calcular(float n1, float n2,char op){
//		
//		switch(op){
//		case '+':soma(n1, n2);break;
//		case '-':subtracao(n1, n2);break;
//		case '*':multiplicacao(n1, n2);break;
//		case '/': divisao(n1, n2);
//		}	
//	}
	
	private void soma(float n1, float n2)
	{
		setRes(n1+n2);
	}
	private void subtracao(float n1, float n2)
	{
		setRes(n1-n2);
	}
	private void multiplicacao(float n1, float n2)
	{
		setRes(n1*n2);
	}
	private void divisao(float n1, float n2)
	{
		setRes(n1/n2);
	}
	
	
	public float getResult()
	{
		return getRes();
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