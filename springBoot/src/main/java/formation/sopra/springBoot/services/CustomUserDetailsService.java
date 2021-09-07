package formation.sopra.springBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.model.Login;
import formation.sopra.springBoot.model.LoginUserDetails;
import formation.sopra.springBoot.repositories.LoginRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> opt = loginRepo.findByLogin(username);
		if (opt.isPresent()) {
			return new LoginUserDetails(opt.get());
		}
		throw new UsernameNotFoundException("");
	}

}
