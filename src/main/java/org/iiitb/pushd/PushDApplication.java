package org.iiitb.pushd;

import org.iiitb.pushd.mail.MailService;
import org.iiitb.pushd.models.Mail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PushDApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PushDApplication.class, args);

		/*Mail mail = new Mail();
        mail.setMailFrom("kunal0199@gmail.com");
        mail.setMailTo("shuddd@gmail.com");
        mail.setMailSubject("Daily dose of Happiness");
        mail.setMailContent("I have chosen to be happy because it's good for my health.");
		MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendEmail(mail);*/
	}

}
