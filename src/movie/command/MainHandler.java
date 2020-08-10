package movie.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.service.MainMovie;
import movie.service.MainMovieService;
import movie.service.MovieNotFoundException;
import mvc.controller.CommandHandler;

public class MainHandler implements CommandHandler{
	
	private MainMovieService mmService = new MainMovieService();	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		// 리스트를 읽어서
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		MainMovie mainMovie = mmService.getMainMovie(pageNo);
		// attribute에 넣어서	
		req.setAttribute("mainMovie", mainMovie);
		
		// index.jsp포워드		
		return "/index.jsp";		
	}

}
