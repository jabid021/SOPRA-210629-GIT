package formation.sopra.springBoot.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserDetails implements UserDetails {

	private Login login;

	public LoginUserDetails(Login login) {
		super();
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(login.getRole().toString()));
	}

	@Override
	public String getPassword() {
		return login.getPassword();
	}

	@Override
	public String getUsername() {
		return login.getLogin();
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
		return true;
	}

}
