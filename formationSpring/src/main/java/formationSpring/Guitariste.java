package formationSpring;

public class Guitariste implements Musicien {

	private Instrument instrument;

	public Instrument getInstrument() {
		return instrument;
	}

	public Guitariste() {

	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("le guitarite joue " + this.instrument.toString());
	}
}
