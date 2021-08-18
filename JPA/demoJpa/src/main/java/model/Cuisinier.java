package model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Cuisinier {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;
	private String prenom;
	
	@Embedded
	@Column(nullable = true)
	private Adresse adresse;
	

	@OneToOne(mappedBy = "chef")
	private Plat specialite;

	@Version
	private int version;
	
	public Cuisinier() {}
	
	public Cuisinier(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Cuisinier(String nom, String prenom,Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse=adresse;
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

	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Cuisinier [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", specialite="
				+ specialite + "]";
	}

	

	





}
