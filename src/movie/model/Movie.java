package movie.model;

import java.util.Date;

public class Movie {
	private Integer number; //movieId
	private String title; 	//movieTitle
	private String director;
	private String genre;	//movieGenre
	private String releaseDate;
	private String fileName;
	private String story;
	
	public Movie(Integer number, String title, String director, 
			String movieGenre, String releaseDate, String story) {
		this(number, title, director, movieGenre, releaseDate, story, "");
		
	}
	


	public Movie(Integer number, String title, String director, 
			String movieGenre, String releaseDate, String fileName, String story) {
		this.number = number;
		this.title = title;
		this.director = director;
		this.genre = movieGenre;
		this.releaseDate = releaseDate;
		this.fileName = fileName;
		this.story = story;
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


	public String getStory() {
		return story;
	}
	
	
}
