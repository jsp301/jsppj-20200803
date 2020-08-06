package movie.model;

import java.util.Date;

public class Movie {
	private Integer number; //movieId
	private String title; 	//movieTitle
	private String director;
	private String genre;	//movieGenre
	private String releaseDate;
	private String fileName;
	
	public Movie(Integer number, String title, String director, 
			String movieGenre, String releaseDate) {
		this(number, title, director, movieGenre, releaseDate, "");
		
	}
	


	public Movie(Integer number, String title, String director, 
			String movieGenre, String releaseDate, String fileName) {
		this.number = number;
		this.title = title;
		this.director = director;
		this.genre = movieGenre;
		this.releaseDate = releaseDate;
		this.fileName = fileName;
	}
	
	
	public Integer getNumber() {
		return number;
	}
	public String getTitle() {
		return title;
	}
	public String getDirector() {
		return director;
	}
	public String getMovieGenre() {
		return genre;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public String getFileName() {
		return fileName;
	}
	
	
}
