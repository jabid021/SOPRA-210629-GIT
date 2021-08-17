package model.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue("lion")
public class Lion extends Animal{

	private boolean adulte;
	public Lion() {
	}
	
	public Lion(String nom, double taille,boolean adulte) {
		super(nom, taille);
		this.adulte=adulte;
	}
	public boolean isAdulte() {
		return adulte;
	}
	public void setAdulte(boolean adulte) {
		this.adulte = adulte;
	}
	@Override
	public String toString() {
		return "Lion [adulte=" + adulte + ", id=" + id + ", nom=" + nom + ", taille=" + taille + "]";
	}



}
