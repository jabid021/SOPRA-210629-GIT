package model.perClass;

import javax.persistence.Entity;

@Entity
public class Bateau extends Vehicule {

	private String nom;
	 public Bateau() {
	}
	public Bateau(String nom,double vitesse) {
		super(vitesse);
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Bateau [nom=" + nom + ", id=" + id + ", vitesse=" + vitesse + "]";
	}
	 
	
	
}
