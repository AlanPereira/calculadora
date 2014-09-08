package edu.pucsp.calculadora.controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class VerificaExpressao {

	//delimitadores 
	private String op;
	//Expressao Matemática
	private ArrayList<String> list;
	
	public VerificaExpressao(){
		this.op = "(+-/*)";
	}

	public boolean validaExpressao(String exp){
		boolean ok = true;
		if(verificaFormat(exp)){
			setList(separaExpressao(exp));
			int n = getList().size();
			int cont = 0,  i = 0;
			String aux = "";	
			while (ok && i < n){
				aux = getList().get(i);
				if(verfOperador(aux)){
					
					if(aux.equals("(")){
						if(i+1< getList().size())
							if(verfOperador(getList().get(i+1), "/*"))
								ok = false;
						cont++;
					}
					else if(aux.equals(")")){
						if(verfOperador(getList().get(i-1), "+-*/"))
							ok = false;
						if(cont>0)
							cont--;
						else
							ok = false;
					}else{
						if((i == 0) && verfOperador(getList().get(i-1), "*/"))
							ok = false;
						else if(i+1 < getList().size()){
							if(verfOperador(getList().get(i+1), "+-/*"))
								ok = false;
						}else{
							ok=false;}
					}
				}
				i++;
			}
			if(cont!=0)
				ok = false;
		}else
			ok = false;
		
		return ok;

	}

	private ArrayList<String> separaExpressao(String expr){

		ArrayList<String> exp = new ArrayList<String>();
		String arr[] = expr.split("");
		int n = 1;
		String numb = "";

		while(n < arr.length){
			System.out.println(arr[n]);
			if(verfOperador(arr[n])){
				exp.add(numb);
				exp.add(arr[n]);
				numb = "";
				//exp.remove("");// remove pq o arrayList acaba add espaço antes de add os parentes
			}else
				numb = numb + arr[n];
			n++;
		}
		exp.add(numb);
		exp.remove("");//remove caso o ultimo seja um operador
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
			return false;

		}
		return ok;
	}

	private boolean verfOperador(String carc){
		String opr[] = this.op.split("");
		boolean ok = false;
		for(int i = 1; i < opr.length;i++){
			if(opr[i].equals(carc)){
				ok = true;
				break;
			}
		}
		return ok;
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

	
	public ArrayList<String> getList() {
		return list;
	}

	
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
}


