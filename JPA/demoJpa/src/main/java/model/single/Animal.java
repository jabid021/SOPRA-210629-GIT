package model.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


//Obligatoire

@Entity
@Table(name="espece")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_espece")
public abstract class Animal {

	//Obligatoire
	@Id
	//Obligatoire*
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id_espece")
	protected int id;
	
	@Column(name="name",nullable = false, columnDefinition ="VARCHAR(70)")
	protected String nom;
	@Column(name="size")
	protected double taille;
	
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
