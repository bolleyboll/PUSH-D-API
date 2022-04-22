package org.iiitb.pushd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chat {
	@Id
	private long id;
	
	@Column(name="senderID", nullable=false)
	private String senderId;
	@Column(name="receiverID", nullable=false)
	private String receiverId;
	@Column(name="message")
	private String message;
	public Chat(long id, String senderId, String receiverId, String message) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.message = message;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Chat [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", message=" + message
				+ "]";
	}
	
	
	
}
