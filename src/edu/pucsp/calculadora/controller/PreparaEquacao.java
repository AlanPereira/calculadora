package edu.pucsp.calculadora.controller;

import java.util.ArrayList;

public class PreparaEquacao {
	private String op;
	
	public PreparaEquacao(){
		this.op = "+-/*^";
	}

	public ArrayList<String> converteInfixa(ArrayList<String> exprI){

		int t = exprI.size();
		ArrayList<String> exprP = new ArrayList<String>();
		ArrayList<String> pilha = new ArrayList<String>();
		for(int i = 0;i<t; i++){
			String carac = exprI.get(i);
			if(verfOperador(carac)){
				int pr = prioridade(carac);
				while(!pilha.isEmpty() && prioridade(pilha.get(pilha.size()-1)) >= pr){
					exprP.add(pilha.remove(pilha.size()-1));
				}
				pilha.add(carac);
			} 
			else if(carac.equals("(")) 
				pilha.add(carac);
			else if(carac.equals(")")){
				String x = pilha.remove(pilha.size()-1); 
				while(!x.equals("(")){
					exprP.add(x);
					x = pilha.remove(pilha.size()-1); 
				}
			}else{//se carac é operando //A, B, C, ... j= j + 1 ExprP[j] = carac
				exprP.add(carac);
			}
		}

		while(!pilha.isEmpty()){
			exprP.add(pilha.remove(pilha.size()-1)); 
		}
		pilha = null;
		System.out.println("Prepara equação ok");
		
		for(int i =0; i<exprP.size();i++){
			System.out.printf(exprP.get(i));
		}
		System.out.println();
		return exprP;
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

	private int prioridade(String opr){
		int prio = 0;
		switch (opr) {
		case "(": case")": prio = 1;break;
		case "+": case"-": prio = 2;break;
		case "*": case"/": prio = 3;break;
		case "^": prio = 4;break;
		}
		return prio;
	}
}
