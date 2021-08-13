package metier;

import java.io.Serializable;

public class Voyage implements Serializable{

	private int id;
	private Trajet trajet;
	private Transport transport;
	//En jour
	private int dureeSejour;


	public Voyage(Trajet trajet, Transport transport, int duree) {
		this.trajet = trajet;
		this.transport = transport;
		this.dureeSejour = duree;
	}
	public Voyage(int id,Trajet trajet, Transport transport, int duree) {
		this.id=id;
		this.trajet = trajet;
		this.transport = transport;
		this.dureeSejour = duree;
	}


	public Voyage(int id) {
		this.id=id;
	}


	public Trajet getTrajet() {
		return trajet;
	}


	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}


	public Transport getTransport() {
		return transport;
	}


	public void setTransport(Transport transport) {
		this.transport = transport;
	}


	public int getDuree() {
		return dureeSejour;
	}


	public void setDuree(int duree) {
		this.dureeSejour = duree;
	}

	public double calculTempsTrajet() 
	{
		return this.trajet.getDistance()/this.transport.getVitesse();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDureeSejour() {
		return dureeSejour;
	}


	public void setDureeSejour(int dureeSejour) {
		this.dureeSejour = dureeSejour;
	}


	@Override
	public String toString() {
		return "Voyage [id=" + id + ", trajet=" + trajet + ", transport=" + transport + ", dureeSejour=" + dureeSejour
				+ "]";
	}

	
	
	
	
	
}
