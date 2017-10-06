package io.zandona.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import io.zandona.model.Movie;

@Transactional
public interface MovieRepository extends CrudRepository<Movie, Long> {

	public Movie findByTitle(String title);
	
}
