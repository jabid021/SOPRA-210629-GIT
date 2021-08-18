package metier;

public enum OldTransport {

	Voiture(1,80), Train(2,300), Avion (3,900), TukTuk (4,20);

	private int vitesse;
	private int id;
	
	private OldTransport(int id,int vitesse) 
	{
		this.vitesse=vitesse;
		this.id=id;
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

	public String toString() 
	{
		return this.name()+" ("+vitesse+" km/h)";
	}
	
	
	
}
