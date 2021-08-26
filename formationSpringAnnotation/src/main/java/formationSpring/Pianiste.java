package formationSpring;

import org.springframework.stereotype.Component;

@Component
public class Pianiste implements Musicien {

	@Override
	public void jouer() {
		System.out.println("le pianiste joue");
	}

	@Override
	public void changerInstrument(Instrument instrument) {
		// TODO Auto-generated method stub
		
	}

}
