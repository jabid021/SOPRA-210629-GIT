package formation.sopra.springBoot.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class ElementAchatKey implements Serializable {
	@ManyToOne
	@JoinColumn(name = "produit_id", foreignKey = @ForeignKey(name = "achat_produit_id_pk"))
	@JsonView(JsonViews.AchatWithClientAndProduit.class)
	private Produit produit;
	@ManyToOne
	@JoinColumn(name = "achat_id", foreignKey = @ForeignKey(name = "achat_achat_id_pk"))
	private Achat achat;

	public ElementAchatKey() {

	}

	public ElementAchatKey(Produit produit, Achat achat) {
		super();
		this.produit = produit;
		this.achat = achat;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Achat getAchat() {
		return achat;
	}

	public void setAchat(Achat achat) {
		this.achat = achat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achat == null) ? 0 : achat.hashCode());
		result = prime * result + ((produit == null) ? 0 : produit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementAchatKey other = (ElementAchatKey) obj;
		if (achat == null) {
			if (other.achat != null)
				return false;
		} else if (!achat.equals(other.achat))
			return false;
		if (produit == null) {
			if (other.produit != null)
				return false;
		} else if (!produit.equals(other.produit))
			return false;
		return true;
	}

}
