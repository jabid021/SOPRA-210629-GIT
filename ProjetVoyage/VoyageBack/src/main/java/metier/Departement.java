package metier;

public class Departement {

	private int id;
	private String nom;
	private String numero;
	private Region region;
	
	
	
	public Departement(int id) {
		this.id=id;
	}

	public Departement(String nom, String numero, Region region) {
		this.nom = nom;
		this.numero = numero;
		this.region = region;
	}

	
	public Departement(int id,String nom, String numero, Region region) {
		this.id=id;
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

	


	
	
	
}
