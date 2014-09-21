package edu.pucsp.calculadora.iface;

public interface ILogFile {
	public boolean gravarDados(String txt);
	public String[] lerDados();
}
