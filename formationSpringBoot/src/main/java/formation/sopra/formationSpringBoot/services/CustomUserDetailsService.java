package formation.sopra.formationSpringBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.model.Utilisateur;
import formation.sopra.formationSpringBoot.model.UtilisateurSpring;
import formation.sopra.formationSpringBoot.repositories.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> opt = utilisateurRepo.findByLogin(username);
		if (opt.isPresent()) {
			return new UtilisateurSpring(opt.get());
		}
		throw new UsernameNotFoundException("utilisateur inconnu");
	}

}
