package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqIngredient",sequenceName ="seqIngredient", initialValue=10 )
public class Ingredient {

	@Id
	@GeneratedValue(generator = "seqIngredient")
	private int id;	
	private String nom;
	private double quantite;
	
	@Enumerated(EnumType.STRING)
	private Unite unite;
	
	@ManyToMany(mappedBy = "ingredients")
	private List<Recette> recettes = new ArrayList();
	
	
	public Ingredient() {
	}
	
	public Ingredient (String nom,Unite unite,double quantite) {
		this.nom=nom;
		this.unite = unite;
		this.quantite=quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public List<Recette> getPlats() {
		return recettes;
	}

	public void setPlats(List<Recette> recettes) {
		this.recettes = recettes;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + ", quantite=" + quantite + ", unite=" + unite+"]";
	}

	

	
	
	
	
	
	
	
}
