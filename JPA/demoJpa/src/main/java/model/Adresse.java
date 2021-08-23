package model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	
	private int numero;
	private String voie;
	private String ville;
	
	public Adresse() {
	}

	public Adresse(int numero, String voie, String ville) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
	
}
