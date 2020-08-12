package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import movie.dao.MovieDao;
import movie.model.Movie;

/**
 * Servlet implementation class InsertCheck
 */
@WebServlet("/InsertCheck")
public class InsertCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		
		
		
		Movie movie = new Movie(null, "title1", "김감독", "로코", "222", "story");
		// type Date형식 일때
		// Movie movie = new Movie(null, "title1", "김감독", "로코", Date.valueOf("2020-10-10"));

		
		try {
			conn = ConnectionProvider.getConnection();
			MovieDao dao = new MovieDao();
			Movie aa = dao.insert(conn, movie);

			System.out.println(aa.getNumber());
			System.out.println(aa.getTitle());
			System.out.println(aa.getDirector());
			System.out.println(aa.getMovieGenre());
			System.out.println(aa.getReleaseDate());
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
