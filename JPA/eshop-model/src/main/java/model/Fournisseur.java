package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fournisseur extends Personne {

	@Column(name="society")
	private String societe;
	
	public Fournisseur() {
		super();
	}

	public Fournisseur(String nom, String prenom,String societe) {
		super(nom, prenom);
		this.societe=societe;
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
