package com.inderjit.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailConfig {

    @Autowired
    JavaMailSender javaMailSender;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean sendMail(String from, String to, String subject, String body) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);
        logger.info("Sending...");
        try {
            javaMailSender.send(mail);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        logger.info("Done!");
        return true;
    }
}
