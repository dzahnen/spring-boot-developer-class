package io.pivotal.workshop.directory.repository;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.workshop.directory.domain.Person;

public interface PersonRepository extends CrudRepository<Person,String>{

	public Person findByEmailIgnoreCase(String email);
}
