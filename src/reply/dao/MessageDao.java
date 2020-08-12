package reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxNotice.SessionStateChangedOrBuilder;

import auth.service.User;
import jdbc.JdbcUtil;
import reply.model.Message;

public class MessageDao {
	private static MessageDao dao = new MessageDao();

	public static MessageDao getInstance() {
		return dao;
	}

	public MessageDao() {

	}

	public int insert(Connection conn, Message message) throws SQLException{

		PreparedStatement pstmt = null;
		try {
//			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(
					"insert into movie_content " + "(movieId, userId, score, content) " + "values (?,?,?,?)");
			pstmt.setInt(1, message.getMovId());
			pstmt.setString(2, message.getuId());
			pstmt.setInt(3, message.getScore());
			pstmt.setString(4, message.getContent());

			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
	}

	/*
	 * public int insert(Connection conn, Message message) throws SQLException {
	 * PreparedStatement pstmt = null; try { pstmt =
	 * conn.prepareStatement("insert into movie_content " +
	 * "(score, content) values (?,?)");
	 * 
	 * pstmt.setInt(1, message.getScore()); pstmt.setString(2,
	 * message.getContent()); return pstmt.executeUpdate(); } finally {
	 * JdbcUtil.close(pstmt); } }
	 */

	public Message select(Connection conn, int movieId) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from movie_content where " + "movieId=? "
					+ "order by contentId");
			pstmt.setInt(1, movieId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return makeMessageFromResultSet(rs);
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setContentId(rs.getInt("contentId"));
		message.setMovId(rs.getInt("movieId"));
		message.setuId(rs.getString("userId"));
		message.setScore(rs.getInt("score"));
		message.setContent(rs.getString("content"));
		return message;
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from movie_content");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from movie_content" + " order by contentId desc limit ?,?");
			pstmt.setInt(1, firstRow - 1);
			pstmt.setInt(2, endRow - firstRow + 1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<Message> messageList = new ArrayList<Message>();
				do {
					messageList.add(makeMessageFromResultSet(rs));

				} while (rs.next());
				return messageList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	/*public int delete(Connection conn, int contentId) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from movie_content where content_id =?");
			pstmt.setInt(1, contentId);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}*/
}
