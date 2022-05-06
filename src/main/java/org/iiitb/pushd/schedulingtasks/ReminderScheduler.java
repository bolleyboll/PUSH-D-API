package org.iiitb.pushd.schedulingtasks;

import org.iiitb.pushd.mail.MailService;
import org.iiitb.pushd.models.Mail;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ReminderScheduler {

    @Autowired
    ApplicationContext ctx;

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy @ HH:mm:ss");

    @Autowired
    PatientRepository pr;
    //MailService mailService;

    @Scheduled(fixedRate = 86400000)
    public void checkForReminder()
    {
        List<Patient> patients = pr.findAll();
        for(Patient p : patients)
        {
            if((new Date().getTime() - p.getLastLogin().getTime())/(1000*60*60) >= 23 && !p.getIsActive())
            {
                getNotification(p.getEmail(),p.getName(),p.getLastLogin());
            }
        }
    }

    public void getNotification(String mailID, String pname, Date lastLogin)
    {
        {
            Mail mail = new Mail();
            mail.setMailFrom("kunal0199@gmail.com");
            mail.setMailTo(mailID);
            mail.setMailSubject("Reminder");
            mail.setMailContent(pname + " you have't login since " + formatter.format(lastLogin));
            MailService mailService = (MailService) ctx.getBean("mailService");
            mailService.sendEmail(mail);
        }
    }
}
