package formation.sopra.formationSpringBoot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/**").authorizeRequests().anyRequest().permitAll();
//				.authorizeRequests()
//					.antMatchers("/","/hello","/public/**","/controller/**").permitAll()
//					.antMatchers("/admin/**").hasAnyRole("ADMIN")
//					.anyRequest().authenticated()
//				.and()
//				.formLogin()
//					.loginPage("/login")
//					.defaultSuccessUrl("/")
//					.failureUrl("/login?error")
//					.permitAll()
//				.and()
//				.logout()
//					.logoutUrl("/logout")
//					.logoutSuccessUrl("/?logout");			
		// @formatter:on
	}

//	@Autowired
//	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
		// auth.inMemoryAuthentication().withUser("user1").password("{noop}user1").roles("USER");

//		// @formatter:off
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.usersByUsernameQuery("select login,password,enable from utilisateur where login=?")
//				.authoritiesByUsernameQuery("select login,role from utilisateur where login=?");
//		// @formatter:on

		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
