package movie.service;

import movie.model.Movie;

public class MovieData {
	private Movie movie;

	public MovieData(Movie movie) {
		super();
		this.movie = movie;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public String getFileName() {
		return movie.getFileName();
	}
	

}
