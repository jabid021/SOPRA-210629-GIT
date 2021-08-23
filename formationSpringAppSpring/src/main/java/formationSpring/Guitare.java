package formationSpring;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements Instrument {
	@Override
	public String toString() {
		return "GLINK GLINK GLINK";
	}
}
