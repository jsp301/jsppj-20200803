package reply.sevice;

import java.sql.Connection; 
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import reply.dao.MessageDao;
import reply.model.Message;



public class GetMessageListService {
	private static GetMessageListService instance = new GetMessageListService();
	
	public static GetMessageListService getInstance() {
		return instance;
	}
	
	private GetMessageListService() {
		
	}
	
	private static final int MESSAGE_COUNT_PER_PAGE = 5;
	
	public MessageListView getMessageList(int pageNumber, int movieId) {
		Connection conn = null;
		
		int currentPageNumber = pageNumber;
		
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			
			int messageTotalCount = messageDao.selectCount(conn, movieId);
			
			List<Message> messageList = null;
			
			int firstRow = 0;
			int endRow = 0;
			
			if (messageTotalCount > 0) {
				firstRow = 
						(pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				messageList = 
						messageDao.selectList(conn, firstRow, endRow);
			} else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();
			}
			
			return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE, firstRow, endRow);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return null;
	}
}
