package fr.blablacar;

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
		 //http.csrf().csrfTokenRepository(csrfTokenRepository)
		http
		.authorizeRequests()
		.antMatchers("/", "/inscription", "/connexion","/api/**", "/console/**","/css/**" ).permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/acceuil")
		.and()
		.logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("moi").password("monmdp").roles("USER");
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