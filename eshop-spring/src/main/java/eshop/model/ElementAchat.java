package eshop.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "element_achat")
public class ElementAchat {
	@EmbeddedId
	private ElementAchatKey id;
	private int quantite;

	public ElementAchat() {

	}

	public ElementAchat(ElementAchatKey id, int quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}

	public ElementAchatKey getId() {
		return id;
	}

	public void setId(ElementAchatKey id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ElementAchat other = (ElementAchat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
