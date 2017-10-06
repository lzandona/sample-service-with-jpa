package io.zandona.controller;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.zandona.model.Movie;
import io.zandona.repository.MovieRepository;

@RestController
public class MovieController {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private MovieRepository repository;
	
	
	@GetMapping("/movie/{id}")
	public Movie findById(@PathVariable(name = "id") Long id) {
		return repository.findOne(id);
	}
	
	@GetMapping("/movie/title/{title}")
	public Movie findByTitle(@PathVariable(name = "title") String title) {
		return repository.findByTitle(title);
	}
	
	@GetMapping("/movie")
	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<>();
		
		repository.findAll().forEach(movies::add);
		
		return movies;
	}
	
	@PostMapping("/movie/create")
	public Movie create(@RequestBody Movie movie) {
		LOG.info("Adding new title: {}", movie.getTitle());
		
		return repository.save(movie);
	}
	
}
