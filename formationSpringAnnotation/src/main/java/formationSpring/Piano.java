package formationSpring;

import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument{
	@Override
	public String toString() {
		return "PLINK PLINK PLINK";
	}
}
