package edu.pucsp.calculadora.controller;

public class Teste {

	public static void main(String[] args) {
		String str = "353+77*(877-44)-888";
		VerificaExpressao  v = new VerificaExpressao();
		
		if(v.validaExpressao(str)){
			System.out.println(str);
		}else
			System.out.println("Falhou");

	}

}

