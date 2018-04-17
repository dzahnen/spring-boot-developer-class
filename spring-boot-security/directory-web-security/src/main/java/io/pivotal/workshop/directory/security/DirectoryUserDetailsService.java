package io.pivotal.workshop.directory.security;

import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.pivotal.workshop.directory.domain.Person;
import io.pivotal.workshop.directory.repository.PersonRepository;

@Component
public class DirectoryUserDetailsService implements UserDetailsService {

	private PersonRepository repo;
	
	public DirectoryUserDetailsService(PersonRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Person person = this.repo.findByEmailIgnoreCase(username);
		GrantedAuthority role = () -> { return person.getRole(); };
		return new User(person.getEmail(), person.getPassword(), Arrays.asList(role));
	}

}
