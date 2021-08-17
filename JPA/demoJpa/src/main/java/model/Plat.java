package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Plat {

	@Id
	private int id;
	private String nom;
	
	@OneToMany(mappedBy = "plat" )
	private List<Recette> recettes=new ArrayList();


	@OneToOne
	@JoinColumn(name="chef")
	private Cuisinier chef;


	public Plat() {}
	
	public Plat(String nom,Cuisinier chef) {
		this.nom=nom;
		this.chef = chef;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Recette> getRecettes() {
		return recettes;
	}


	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}


	public Cuisinier getChef() {
		return chef;
	}


	public void setChef(Cuisinier chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Plat [id=" + id + ", nom=" + nom + ", chef=" + chef + "]";
	}

	


	



}
