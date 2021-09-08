package formation.sopra.formationSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Produit {
	private String nom;
	private double prix;
	@JsonIgnore
	private Categorie categorie;

	public Produit() {

	}

	public Produit(String nom, double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Produit(String nom, double prix, Categorie categorie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
