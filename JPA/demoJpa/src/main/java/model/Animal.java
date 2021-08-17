package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Obligatoire
@Entity
@Table(name="espece")
public class Animal {

	//Obligatoire
	@Id
	//Obligatoire*
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String nom;
	private double taille;
	
	public Animal() {}

	public Animal(int id, String nom, double taille) {
		this.id = id;
		this.nom = nom;
		this.taille = taille;
	}
	
	public Animal(String nom, double taille) {
		this.nom = nom;
		this.taille = taille;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom + ", taille=" + taille + "]";
	}
	
	
	


	
	
	
	
	
	
}
