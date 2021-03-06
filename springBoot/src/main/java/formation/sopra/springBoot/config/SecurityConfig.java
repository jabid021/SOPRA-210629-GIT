package formation.sopra.springBoot.config;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/api/**")
			.csrf().ignoringAntMatchers("/api/**")
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS,"/api/**").anonymous()
				.antMatchers(HttpMethod.POST, "/api/client/inscription").anonymous()
				.antMatchers("/api/login").authenticated()
				.antMatchers("/api/login/isPresent/**").permitAll()
				.antMatchers(HttpMethod.GET,"/api/produit").permitAll()
				.antMatchers("/api/produit/**").authenticated()
				.antMatchers("/api/fournisseur/**").hasAnyRole("ADMIN")
				.antMatchers("/api/achat").hasAnyRole("USER")
			.and()
			.httpBasic()
			.and()
			.antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/achat/**").permitAll()
					.antMatchers(HttpMethod.POST,"/client/save").permitAll()
					.antMatchers("/client/inscription").anonymous()
					.anyRequest().authenticated()
				.and()
				.formLogin();
		// @formatter:on

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
