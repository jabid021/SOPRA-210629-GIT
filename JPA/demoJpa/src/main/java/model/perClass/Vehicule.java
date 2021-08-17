package model.perClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected int id;
	protected double vitesse;
	
	public Vehicule() {
	}

	public Vehicule(int id,double vitesse) {
		this.id = id;
		this.vitesse = vitesse;
	}
	
	public Vehicule(double vitesse) {
		this.vitesse = vitesse;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVitesse() {
		return vitesse;
	}

	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}
	
	
	
}
