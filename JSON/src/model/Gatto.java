package model;

public class Gatto {
	
	String nome;
	String colore;
	public Gatto(String nome, String colore) {

		this.nome = nome;
		this.colore = colore;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}

}
