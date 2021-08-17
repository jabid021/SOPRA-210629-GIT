package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cuisinier {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;
	private String prenom;

	@OneToOne(mappedBy = "chef")
	private Plat specialite;


	public Cuisinier() {}
	
	public Cuisinier(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Plat getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Plat specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Cuisinier [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	





}
