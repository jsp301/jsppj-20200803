package movie.service;

import java.util.List;

import movie.model.Movie;

public class SearchMovie {
	private Movie movie;

	private List<Movie> content;
	private int total;
	private int currentPage;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	
	public SearchMovie(Movie movie, List<Movie> content, int total, int currentPage, int totalPages, int startPage,
			int endPage) {
		super();
		this.movie = movie;
		this.content = content;
		this.total = total;
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	
	public SearchMovie(int total, int currentPage, int size,
			List<Movie> content ) {
		this.content = content;
		this.currentPage = currentPage;
		this.total=total;
		if(total ==0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			//totalPages
			totalPages = total/size;
			if(total%size>0) {
				totalPages++;
			}
			
			//startPage
			int modVal = currentPage % 5;
			startPage = currentPage/5*5+1;
			if(modVal==0) startPage -= 5;
			
			//endPage
			endPage = startPage +4;
			if(endPage > totalPages) endPage = totalPages;
	}	}
	
	
	
	
	public Movie getMovie() {
		return movie;
	}
	public List<Movie> getContent() {
		return content;
	}
	public int getTotal() {
		return total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}

	
	public boolean hasNoMovies() {
		return total == 0;
	}
	public boolean hasMovies() {
		return total > 0;
	}
}
