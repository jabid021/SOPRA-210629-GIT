package voyage.metier;

import javax.persistence.*;

@Entity
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	private String nom;
	private String numero;
	@Enumerated(EnumType.STRING)
	private Region region;

	public Departement(int id) {
		this.id = id;
	}

	public Departement() {
	}

	public Departement(String nom, String numero, Region region) {
		this.nom = nom;
		this.numero = numero;
		this.region = region;
	}

	public Departement(int id, String nom, String numero, Region region) {
		this.id = id;
		this.nom = nom;
		this.numero = numero;
		this.region = region;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + ", numero=" + numero + ", region=" + region + "]";
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
		Departement other = (Departement) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
