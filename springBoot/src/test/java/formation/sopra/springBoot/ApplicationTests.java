package formation.sopra.springBoot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import formation.sopra.springBoot.model.Login;
import formation.sopra.springBoot.model.Role;
import formation.sopra.springBoot.repositories.LoginRepository;

@SpringBootTest
class ApplicationTests {

	@Autowired
	LoginRepository loginRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
		Login login = new Login("admin", passwordEncoder.encode("admin"), Role.ROLE_ADMIN);
		loginRepo.save(login);
		loginRepo.save(new Login("toto", passwordEncoder.encode("toto"), Role.ROLE_USER));
	}

}
