package reply.sevice;

import java.sql.Connection;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import reply.dao.MessageDao;
import reply.model.Message; 



public class WriteMessageService {
	private static WriteMessageService instance = new WriteMessageService();
	
	public static WriteMessageService getInstance() {
		return instance;
	}
	
	private WriteMessageService() {
	}
	
	public boolean write(Message message) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			messageDao.insert(conn, message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JdbcUtil.close(conn);
		}
		
		return true;
		
		
	}
}







