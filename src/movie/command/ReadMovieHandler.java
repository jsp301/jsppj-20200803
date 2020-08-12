package movie.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import movie.service.MovieData;
import movie.service.MovieNotFoundException;
import movie.service.ReadMovieService;
import mvc.controller.CommandHandler;
import reply.dao.MessageDao;
import reply.model.Message;
import reply.sevice.GetMessageListService;
import reply.sevice.MessageListView;

public class ReadMovieHandler implements CommandHandler {
	
	private ReadMovieService readService = new ReadMovieService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		Connection conn = ConnectionProvider.getConnection();
		// no <- MovieDao의  selectById
		String noVal = req.getParameter("no");
		int movieNum = Integer.parseInt(noVal);
		
		String pageStr = req.getParameter("page");
		int page =1;
		
		
		try {
			if(pageStr != null) {
				page = Integer.valueOf(pageStr);
			}
			MovieData movieData = readService.getMovie(movieNum);
			
			MessageDao messagedao = MessageDao.getInstance();
			Message contentList = messagedao.select(conn, movieNum);
			
			GetMessageListService service = GetMessageListService.getInstance();
			MessageListView list = service.getMessageList(page);
			
			int score = readService.getScore(movieNum);
			
			req.setAttribute("avgscore", score);
			
			req.setAttribute("contentList", contentList);
			req.setAttribute("list", list);
			req.setAttribute("movieData", movieData);
			
			return "/WEB-INF/view/readMovie.jsp";
			
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
			req.getServletContext().log("no movie", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	
	
}
