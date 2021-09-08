package formation.sopra.formationSpringBoot.model;

import java.util.List;

public class Categorie {
	private String nom;
	private List<Produit> produits;

	public Categorie() {

	}

	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	
	
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
