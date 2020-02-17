package com.apap.tu03.service;

import java.util.List;
import com.apap.tu03.model.MovieModel;

public interface MovieService {
	
	List<MovieModel> getMovieList();

	MovieModel getMovieDetail(String id);

	void addMovie(MovieModel movie);

	void deleteMovie(MovieModel movie);

	void updateMovie(MovieModel movie, int duration);
}