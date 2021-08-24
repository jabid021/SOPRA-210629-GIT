package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AppSpring {

	@Autowired
	@Qualifier("pianiste")
	private Musicien musicien;



	public AppSpring() {

	}

	public void run(String[] args) {

		musicien.jouer();
	
	}
}
