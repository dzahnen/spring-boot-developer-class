package io.pivotal.workshop.snippet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
@Configuration
public class SnippetOAuth2Config extends ResourceServerConfigurerAdapter{

	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/api/**")
				// Add below
				.authorizeRequests().anyRequest().authenticated();
	}
	
}
