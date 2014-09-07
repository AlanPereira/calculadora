package edu.pucsp.calculadora.controller;

import java.security.acl.Permission;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VerificaExpressao {

	public boolean validaExpressao(String exp){
		boolean ok = true;
		if(verificaFormat(exp)){
		ArrayList<String> list = separaExpressao(exp);
		int n = list.size();
		int cont = 0,  i = 0;
		String aux;	
		while (ok && i < n){
				aux = list.get(i);
				i++;
				if(aux.equals("("))
					cont++;
				else if(aux.equals(")"))
					if(cont>0)
						cont--;
					else
						ok = false;
		}
		if(cont!=0)
			ok = false;
		}else
			ok = false;
		return ok;
				
	}
	
	private ArrayList<String> separaExpressao(String expr)
	{
		ArrayList<String> exp = new ArrayList<String>();
		
		int n = 0;
		String numb = "";
		while(n<expr.length())
		{
			
			if(expr.charAt(n) == '+' || expr.charAt(n) == '-' ||
					expr.charAt(n) == '*'||expr.charAt(n) == '/'|| 
					expr.charAt(n) == '('||expr.charAt(n) == ')'){
				exp.add(numb);
				exp.add(""+expr.charAt(n));
				numb = "";
			}else
				numb = "" + expr.charAt(n);
		}
		exp.add(numb);
		return exp;
	}
	private boolean verificaFormat(String exp)
	{
		boolean ok = true;
		String delim = "+-/*()";
		StringTokenizer st = new StringTokenizer(exp, delim);
		try{
		while (st.hasMoreElements()) {
			Double.parseDouble((String) st.nextElement());
		}
		}catch (NumberFormatException e) {
			return false;
		}
			return ok;
	}
}
