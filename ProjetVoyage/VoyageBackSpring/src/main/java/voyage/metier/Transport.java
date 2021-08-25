package voyage.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transport {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	private String nom;
	private int vitesse;

	public Transport() {
	}

	public Transport(int id, String nom, int vitesse) {
		this.nom = nom;
		this.vitesse = vitesse;
		this.id = id;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Transport [nom=" + nom + ", vitesse=" + vitesse + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Transport other = (Transport) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
