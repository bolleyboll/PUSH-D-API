package org.iiitb.pushd.mail;

public interface MailerService {
	void sendSimpleMessage(String to, String subject, String text);
}
