package com.apap.tu03.controller;

import java.util.List;
import java.util.Optional;

import com.apap.tu03.model.MovieModel;
import com.apap.tu03.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;

	@RequestMapping("/movie/add")
	public String add(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "genre", required = true) String genre,
			@RequestParam(value = "budget", required = true) Long budget,
			@RequestParam(value = "duration", required = true) Integer duration) {
		MovieModel movie = new MovieModel(id, title, genre, budget, duration);
		movieService.addMovie(movie);
		return "add";
	}

	// @RequestMapping("/movie/view")
	// public String view(@RequestParam("id") String id, Model model){
	// 	MovieModel archive = movieService.getMovieDetail(id);
	// 	model.addAttribute("movie", archive);
	// 	return "view-movie";
	// }

	@RequestMapping(value= {"/movie/view","movie/view/{id}"})
	public String view(@PathVariable Optional<String> id, Model model){
		if(id.isPresent()){
			MovieModel archive = movieService.getMovieDetail(id.get());
			if(archive == null){
				model.addAttribute("errMessage", "ID not found");
				return "errPage";
			}else{
				model.addAttribute("movie", archive);
				return "view-movie";
			}
		}else{
			model.addAttribute("errMessage", "ID is empty");
			return "errPage";
		}
	}

	@RequestMapping("/movie/viewall")
	public String viewAll(Model model){
		List<MovieModel> archive = movieService.getMovieList();
		model.addAttribute("movies", archive);
		return "viewall-movie";
	}

	@RequestMapping(value={"/movie/update", "movie/update/{id}/{duration}"})
	public String update(@PathVariable Optional<String> id, @PathVariable Optional<Integer> duration, Model model){
		if(id.isPresent() && duration.isPresent()){
			MovieModel archive = movieService.getMovieDetail(id.get());
			if(archive == null){
				model.addAttribute("errMessage", "Data not found");
				return "errPage";
			}else{
				model.addAttribute("errMessage", "Data has been updated successfully");
				movieService.updateMovie(archive, duration.get());
				return "errPage";
			}
		}else{
			model.addAttribute("errMessage", "Data is empty");
			return "errPage";
		}
	}


	@RequestMapping(value={"/movie/delete", "movie/delete/{id}"})
	public String delete(@PathVariable Optional<String> id, Model model){
		if(id.isPresent()){
			MovieModel archive = movieService.getMovieDetail(id.get());
			if(archive == null){
				model.addAttribute("errMessage", "Data not found");
			}else{
				model.addAttribute("errMessage", "Data has been removed");
				movieService.deleteMovie(archive);
			}
		}else{
			model.addAttribute("errMessage", "Data is empty");
		}
		return "errPage";
	}

}