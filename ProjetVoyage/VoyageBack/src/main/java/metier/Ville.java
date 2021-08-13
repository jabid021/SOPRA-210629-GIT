package metier;

public class Ville {
	private int id;
	private String nom;
	private String carac ;
	private Departement departement;
	
	
	public Ville(int id,String nom, String carac, Departement departement) {
		this.id=id;
		this.nom = nom;
		this.carac = carac;
		this.departement = departement;
	}
	

	public Ville(String nom, String carac, Departement departement) {
		this.nom = nom;
		this.carac = carac;
		this.departement = departement;
	}


	public Ville(int id) {
		this.id=id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCarac() {
		return carac;
	}


	public void setCarac(String carac) {
		this.carac = carac;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", carac=" + carac + ", departement=" + departement + "]";
	}


	
	
	
	
	
}
