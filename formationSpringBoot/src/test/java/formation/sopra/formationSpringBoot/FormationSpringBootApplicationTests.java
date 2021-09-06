package formation.sopra.formationSpringBoot;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formation.sopra.formationSpringBoot.repositories.UtilisateurRepository;

@SpringBootTest
class FormationSpringBootApplicationTests {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Test
	void contextLoads() {
		assertNotNull(utilisateurRepo);
	}

}
