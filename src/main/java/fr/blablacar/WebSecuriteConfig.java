package fr.blablacar;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecuriteConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/", "/inscription", "/connexion", "/api/**", "/console/**", "/css/**").permitAll()
				.anyRequest().authenticated().and()
				.formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/acceuil").and()
				.logout().permitAll()
				.and().headers().frameOptions().sameOrigin()
				.httpStrictTransportSecurity().disable();
	}
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	public DaoAuthenticationProvider authProvider() {
//	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//	    authProvider.setUserDetailsService(userDetailsService);
//	    authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
//	    return authProvider;
//	}
	
	@Autowired
	public void y(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("select email as username, mot_de_passe as password, active as enabled from \"personne\" where email = ?")
		.authoritiesByUsernameQuery("select email as username, role from \"roles\" where email = ?");
		
		
		/*
		auth.inMemoryAuthentication().withUser("seba").password("mdp").roles("USER");
		auth.jdbcAuthentication().dataSource(dataSource).withUser("moi").password("mdp").roles("ADMIN");
		
CREATE TABLE "roles" (
  "email" varchar(20) NOT NULL,
  "role" varchar(20) NOT NULL,
  PRIMARY KEY ("email")
  );
  
ALTER Table roles Add foreign key (email) REFERENCES personne (email);

  
  
CREATE TABLE "Users" (
  "username" varchar(20) NOT NULL,
  "password" varchar(20) NOT NULL,
  "enabled" bool NOT NULL DEFAULT true,
  PRIMARY KEY ("username")
);

CREATE TABLE "Roles" (
  "username" varchar(20) NOT NULL,
  "role" varchar(20) NOT NULL,
  PRIMARY KEY ("username","role"),
  FOREIGN KEY (username) REFERENCES users (username)
);

ALTER Table Roles Add foreign key (username) REFERENCES users (username);

INSERT INTO "Users" (username, password, enabled)
VALUES ('seba', 'mdp', true);


INSERT INTO "Roles" (username, role)
VALUES
	('seba', 'Admin'),
	('seba', 'CEO');

commit;
		*/
		
	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(inMemoryUserDetailsManager()); }
	 * 
	 * 
	 * @Bean public InMemoryUserDetailsManager inMemoryUserDetailsManager() { final
	 * Properties users = new Properties(); users.put("user",
	 * "pass,ROLE_USER,enabled"); //add whatever other user you need return new
	 * InMemoryUserDetailsManager(users); }
	 */
}
