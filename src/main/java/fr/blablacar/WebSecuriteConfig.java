package fr.blablacar;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from \"Users\" where username = ?")
		.authoritiesByUsernameQuery("select username, role from \"Roles\" where username = ?");
		
		/*
		auth.inMemoryAuthentication().withUser("seba").password("mdp").roles("USER");
		auth.jdbcAuthentication().dataSource(dataSource).withUser("moi").password("mdp").roles("ADMIN");
		
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



INSERT INTO "Users" ("username", "password", "enabled")
VALUES
	("seba", "mdp", true);

INSERT INTO "Roles" ("username", "role")
VALUES
	("seba", "Admin"),
	("seba", "CEO");

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
