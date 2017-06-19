package yjc.wdb.somebodyplace.bean;

import java.sql.Timestamp;

public class Chatting {
	
	private String sender;
	private String receiver;
	private String content;
	private Timestamp time;
	
	private String chat_sender;
	private String chat_receiver;
	private String chat_content;
	private Timestamp chat_time;
		
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getChat_sender() {
		return chat_sender;
	}
	public void setChat_sender(String chat_sender) {
		this.chat_sender = chat_sender;
	}
	public String getChat_receiver() {
		return chat_receiver;
	}
	public void setChat_receiver(String chat_receiver) {
		this.chat_receiver = chat_receiver;
	}
	public String getChat_content() {
		return chat_content;
	}
	public void setChat_content(String chat_content) {
		this.chat_content = chat_content;
	}
	public Timestamp getChat_time() {
		return chat_time;
	}
	public void setChat_time(Timestamp chat_time) {
		this.chat_time = chat_time;
	}
}