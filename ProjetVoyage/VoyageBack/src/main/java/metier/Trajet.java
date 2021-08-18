package metier;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trajet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="id_depart")
	private Ville depart;
	@ManyToOne
	@JoinColumn(name="id_destination")
	private Ville destination ;
	private double distance;
	
	public Trajet() {}
	public Trajet(Ville depart, Ville destination, double distance) {
		this.depart = depart;
		this.destination = destination;
		this.distance = distance;
	}

	
	public Trajet(int id,Ville depart, Ville destination, double distance) {
		this.id=id;
		this.depart = depart;
		this.destination = destination;
		this.distance = distance;
	}
	
	
	public Trajet(int id) {
		this.id=id;
	}

	public Ville getDepart() {
		return depart;
	}

	public void setDepart(Ville depart) {
		this.depart = depart;
	}

	public Ville getDestination() {
		return destination;
	}

	public void setDestination(Ville destination) {
		this.destination = destination;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Trajet [id=" + id + ", depart=" + depart + ", destination=" + destination + ", distance=" + distance
				+ "]";
	}

	
	
	
}
