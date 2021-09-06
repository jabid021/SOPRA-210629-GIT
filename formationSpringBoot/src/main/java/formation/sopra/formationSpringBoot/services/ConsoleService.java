package formation.sopra.formationSpringBoot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.repositories.UtilisateurRepository;

@Service
public class ConsoleService implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleService.class);

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Override
	public void run(String... args) throws Exception {
//		LOGGER.trace("un message TRACE");
//		LOGGER.debug("un message DEBUG");
//		LOGGER.info("un meesage INFO");
//		LOGGER.warn("un message WARN");
//		LOGGER.error("un message ERROR");
//		System.out.println("hello world");

		//initPassword();
	}

	private void initPassword() {
		utilisateurRepo.findAll().stream().forEach(u -> {
			u.setPassword(passwordEncoder.encode(u.getLogin()));
			utilisateurRepo.save(u);
		});
	}

}
