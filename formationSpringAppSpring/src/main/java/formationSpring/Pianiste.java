package formationSpring;

import org.springframework.stereotype.Component;

@Component
public class Pianiste implements Musicien {

	@Override
	public void jouer() {
		//System.out.println("jouer du pianiste");
		throw new NullPointerException();
	}

	@Override
	public void changerInstrument(Instrument instrument) {
		// TODO Auto-generated method stub

	}

}
