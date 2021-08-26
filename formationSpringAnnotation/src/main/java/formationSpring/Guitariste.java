package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements Musicien {

	@Autowired
	@Qualifier("guitare")
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

	@Override
	public void changerInstrument(Instrument instrument) {
		this.setInstrument(instrument);
	}

	@Override
	public String toString() {
		return "Guitariste [instrument=" + instrument + "]";
	}
	
	public String jeJoue() {
		try {
		return("je joue cet instrument : "+instrument.toString());
		}catch(Exception e){
			e.printStackTrace();
			return("je ne joue rien ");
		}
	}
}
