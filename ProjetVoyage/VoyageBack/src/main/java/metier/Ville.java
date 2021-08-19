package metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ville {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@Column(columnDefinition = "TEXT")
	private String carac;
	
	@ManyToOne
	@JoinColumn(name="id_departement")
	private  Departement departement;
	
	@OneToMany(mappedBy = "depart" )
	private List<Trajet> trajetsDepart;
	@OneToMany(mappedBy = "destination" )
	private List<Trajet> trajetsDestination;
	
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
	

	public Ville() {}


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


	public List<Trajet> getTrajetsDepart() {
		return trajetsDepart;
	}


	public void setTrajetsDepart(List<Trajet> trajetsDepart) {
		this.trajetsDepart = trajetsDepart;
	}


	public List<Trajet> getTrajetsDestination() {
		return trajetsDestination;
	}


	public void setTrajetsDestination(List<Trajet> trajetsDestination) {
		this.trajetsDestination = trajetsDestination;
	}


	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", carac=" + carac + ", departement=" + departement + "]";
	}


	
}
