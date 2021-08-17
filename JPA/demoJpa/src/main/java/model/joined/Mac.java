package model.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idOrdiFK")
public class Mac extends Ordinateur {

	private double prix;
	
	public Mac() {
		super();
	}

	public Mac(String marque,double prix) {
		super(marque);
		this.prix=prix;
	}

	
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Mac [prix=" + prix + ", id=" + id + ", marque=" + marque + "]";
	}
	
}
