package model.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue("dog")
public class Chien extends Animal{

	private boolean domestique;
	
	public Chien() {
	}
	public Chien(String nom, double taille,boolean domestique) {
		super(nom, taille);
		this.domestique=domestique;
	}
	public boolean isDomestique() {
		return domestique;
	}
	public void setDomestique(boolean domestique) {
		this.domestique = domestique;
	}
	@Override
	public String toString() {
		return "Chien [domestique=" + domestique + ", id=" + id + ", nom=" + nom + ", taille=" + taille + "]";
	}
	
	
	
}
