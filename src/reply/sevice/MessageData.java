package reply.sevice;

import reply.model.Message;

public class MessageData {
	private Message message;
	
	public MessageData(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return message;
	}
}
