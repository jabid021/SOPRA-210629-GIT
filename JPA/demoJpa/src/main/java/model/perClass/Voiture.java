package model.perClass;

import javax.persistence.Entity;

//@Entity
public class Voiture extends Vehicule{

	private String couleur;
	
	
	public Voiture() {
	}
	
	public Voiture(String couleur,double vitesse) {
		super(vitesse);
		this.couleur=couleur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Voiture [couleur=" + couleur + ", id=" + id + ", vitesse=" + vitesse + "]";
	}
	
	
}
