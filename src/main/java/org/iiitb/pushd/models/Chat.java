package org.iiitb.pushd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
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
	
}
