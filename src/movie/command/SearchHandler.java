package movie.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.service.SearchMovie;
import movie.service.SearchMovieService;
import mvc.controller.CommandHandler;

public class SearchHandler implements CommandHandler {
	
	private SearchMovieService smService = new SearchMovieService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		String search = "";
		if(req.getParameter("sv") != null) {
			search = req.getParameter("sv");
		}
		
		SearchMovie searchMovie = smService.getSearchMovie(pageNo, search);
		
		req.setAttribute("searchMovie", searchMovie);
		
		return "/WEB-INF/view/SearchMovieList.jsp";
	}
	
}
