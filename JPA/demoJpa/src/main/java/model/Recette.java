package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Recette {

	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_plat")
	private Plat plat;
	
	@ManyToMany
	@JoinTable
	(
		name="composition",
		joinColumns = @JoinColumn(name="recette"),
		inverseJoinColumns =  @JoinColumn(name="ingredient")
	)
	private List<Ingredient> ingredients=new ArrayList();

	
	public Recette() {}

	public Recette(Plat plat,List<Ingredient> ingredients) {
		this.plat = plat;
		this.ingredients=ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recette [id=" + id + ", plat=" + plat + ", ingredients=" + ingredients + "]";
	}

	

	
	
	
	
}
