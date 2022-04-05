package org.iiitb.pushd;

import org.iiitb.pushd.mail.MailService;
import org.iiitb.pushd.models.Mail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PushDApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PushDApplication.class, args);

		Mail mail = new Mail();
        mail.setMailFrom("aman.iv0012@gmail.com");
        mail.setMailTo("aman.gupta@iiitb.ac.in");
        mail.setMailSubject("Aur Lodu");
        mail.setMailContent("Chal Gya mail");
		MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendEmail(mail);
	}

}
