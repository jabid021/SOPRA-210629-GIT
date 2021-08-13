package metier;

public class Trajet {
	private int id;
	private Ville depart;
	private Ville destination ;
	private double distance;
	
	
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
