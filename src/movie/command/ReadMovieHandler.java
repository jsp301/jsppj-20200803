package movie.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.service.MovieData;
import movie.service.MovieNotFoundException;
import movie.service.ReadMovieService;
import mvc.controller.CommandHandler;

public class ReadMovieHandler implements CommandHandler {
	
	private ReadMovieService readService = new ReadMovieService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		// no <- MovieDao의  selectById
		String noVal = req.getParameter("no");
		int movieNum = Integer.parseInt(noVal);
		
		try {
			MovieData movieData = readService.getMovie(movieNum);
			
			req.setAttribute("MovieData", movieData);
			return "/WEB-INF/view/readMovie.jsp";
			
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
			req.getServletContext().log("no movie", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	
	
}
