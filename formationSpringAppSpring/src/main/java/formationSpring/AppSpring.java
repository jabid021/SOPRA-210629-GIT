package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;

public class AppSpring {

	@Autowired
	private Musicien musicien;

	public AppSpring() {

	}

	public void run(String[] args) {
		System.out.println("dans le run");
		musicien.jouer();
	}
}
