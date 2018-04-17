package io.pivotal.workshop.directory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import io.pivotal.workshop.directory.security.DirectoryUserDetailsService;

@Configuration
public class DirectorySecurityConfig extends WebSecurityConfigurerAdapter{

	private DirectoryUserDetailsService userDetailsService;
	public DirectorySecurityConfig(DirectoryUserDetailsService userDetailsService){
		this.userDetailsService = userDetailsService;
	}
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
	        .csrf().disable()
	        .authorizeRequests()
			.antMatchers("/css/**","/js/**","/").permitAll()
			.anyRequest().fullyAuthenticated() 
			.and()
			.formLogin()
			.and().logout().permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
}
