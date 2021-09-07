package formation.sopra.formationSpringBoot.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UtilisateurSpring implements UserDetails {

	private Utilisateur utilisateur;

	public UtilisateurSpring(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(utilisateur.getRole().toString()));
	}

	@Override
	public String getPassword() {
		return utilisateur.getPassword();
	}

	@Override
	public String getUsername() {
		return utilisateur.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return utilisateur.isEnable();
	}

}
