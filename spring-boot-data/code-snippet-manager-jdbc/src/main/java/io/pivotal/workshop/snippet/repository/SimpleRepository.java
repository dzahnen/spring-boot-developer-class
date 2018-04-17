package io.pivotal.workshop.snippet.repository;

import java.util.Collection;

public interface SimpleRepository<T> {

	Iterable<T> findAll();
	void save(Collection<T> items);
	T save(T item);
	T findOne(String id);
}
