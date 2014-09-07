package edu.pucsp.calculadora.model;


public class Calculadora{
	
	private float res;
	
	public float getRes() {
		return res;
	}

	public void setRes(float res) {
		this.res = res;
	}

	public Calculadora(float n1,float n2, char op){ 
		calcular(n1, n2, op);		
	}

	private void calcular(float n1, float n2,char op){
		
		switch(op){
		case '+':soma(n1, n2);break;
		case '-':subtracao(n1, n2);break;
		case '*':multiplicacao(n1, n2);break;
		case '/': divisao(n1, n2);
		}	
	}
	
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
}