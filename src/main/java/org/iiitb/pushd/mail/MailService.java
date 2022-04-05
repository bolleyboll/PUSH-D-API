package org.iiitb.pushd.mail;

import org.iiitb.pushd.models.Mail;

public interface MailService {
    public void sendEmail(Mail mail);
}