package com.apap.tu03.model;

public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private Long budget;
	private Integer duration;

	public MovieModel(String id, String title, String genre, Long budget, Integer duration) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.budget = budget;
		this.duration = duration;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public Long getBudget() {
		return budget;
	}

	public Integer getDuration() {
		return duration;
	}
}