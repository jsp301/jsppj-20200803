package reply.command;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import movie.dao.MovieDao;
import movie.model.Movie;
import mvc.controller.CommandHandler;
import reply.dao.MessageDao;
import reply.model.Message;

public class ReadReplyHandler implements CommandHandler{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = ConnectionProvider.getConnection();
		String num = request.getParameter("no");
		int movieNum = Integer.parseInt(num);
		
		MovieDao moviedao = new MovieDao();
		Movie movie =moviedao.selectById(conn, movieNum);
		int result =moviedao.selectCount(conn);
		
		MessageDao messagedao = MessageDao.getInstance();
		Message contentList = messagedao.select(conn, movieNum);
		
		request.setAttribute("contentList", contentList);
		
		
		request.setAttribute("movie", movie);
		
		return "/WEB-INF/view/readMovie.jsp";
	}

}
