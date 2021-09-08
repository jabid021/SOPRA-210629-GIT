package formation.sopra.springBoot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Fournisseur extends Personne {
	@Size(min = 2, message = "le nom de la societe doit etre de 2 caracteres")
	@Column(name = "society")
	@JsonView(JsonViews.Common.class)
	private String societe;
	@OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
	@JsonView(JsonViews.FournisseurWithProduits.class)
	private List<Produit> produits;

	public Fournisseur() {
		super();
	}

	public Fournisseur(String nom, String prenom, String societe) {
		super(nom, prenom);
		this.societe = societe;
	}

	public String getInfos() {
		return id + " " + prenom + " " + nom + " " + societe;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	@Override
	public String toString() {
		return "Fournisseur [societe=" + societe + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
