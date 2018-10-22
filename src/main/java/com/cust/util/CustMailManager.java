package com.cust.util;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class CustMailManager {

    @Autowired
    private JavaMailSender mailSender;
    private MimeMessagePreparator preparator;

    public void sendMail(String from, String to, String cc, String bcc, String subject, String msg) {

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        mailSender.send(message);
        preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipients(Message.RecipientType.TO, to);
                mimeMessage.setRecipients(Message.RecipientType.CC, cc);                
                mimeMessage.setRecipients(Message.RecipientType.BCC, bcc);                                
                mimeMessage.setSubject(subject);
//                mimeMessage.setRecipient(Message.RecipientType.TO,
//                        new InternetAddress(to));
                mimeMessage.setFrom(new InternetAddress(from));
                mimeMessage.setContent(msg,"text/html");
            }
        };
        try {
            mailSender.send(preparator);
        } catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }

    }

    /**
     * @param mailSender the mailSender to set
     */
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

}
