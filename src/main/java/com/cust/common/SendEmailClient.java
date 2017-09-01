package com.cust.common;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ISanhot
 */
public class SendEmailClient {

    private String userName;
    private String password;
    private String sendingHost;
    private int sendingPort;
    private String from;
    private String to;
    private String subject;
    private String text;
    private String receivingHost;
//    private int receivingPort;

    public void setAccountDetails(String userName, String password) {

        this.userName = userName;//sender's email can also use as User Name
        this.password = password;

    }

    public void sendGmail(String from, String to, String subject, String text) {

        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;

        this.sendingHost = "smtp.gmail.com";
        this.sendingPort = 465;

        Properties props = new Properties();
        props.put("mail.smtp.host", this.sendingHost);
        props.put("mail.smtp.port", String.valueOf(this.sendingPort));
        props.put("mail.smtp.user", this.userName);
        props.put("mail.smtp.password", this.password);
        props.put("mail.smtp.auth", "true");

        Session session1 = Session.getDefaultInstance(props);
        Message simpleMessage = new MimeMessage(session1);

        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;
        try {
            fromAddress = new InternetAddress(this.from);
            toAddress = new InternetAddress(this.to);
        } catch (AddressException e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Sending email to: " + to + " failed !!!", "Falied to Send!!!", JOptionPane.ERROR_MESSAGE);
        }

        try {
            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipient(RecipientType.TO, toAddress);

            // to add CC or BCC use
            simpleMessage.setRecipient(RecipientType.BCC, new InternetAddress("eleganinfo@gmail.com"));
            // simpleMessage.setRecipient(RecipientType.BCC, new InternetAddress("CBC_Recipient@any_mail.com"));
            simpleMessage.setSubject(this.subject);
            simpleMessage.setContent(this.text,"text/html");
            //sometimes Transport.send(simpleMessage); is used, but for gmail it's different

            Transport transport = session1.getTransport("smtps");
            transport.connect(this.sendingHost, sendingPort, this.userName, this.password);
            transport.sendMessage(simpleMessage, simpleMessage.getAllRecipients());
            transport.close();
//            JOptionPane.showMessageDialog(null, "Mail sent successfully ...", "Mail sent", JOptionPane.PLAIN_MESSAGE);
        } catch (MessagingException e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Sending email to: " + to + " failed !!!", "Falied to Send!!!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void readGmail() {

        this.receivingHost = "imap.gmail.com";
        Properties props2 = System.getProperties();
        props2.setProperty("mail.smtp.ssl.enable", "true");

        Session session2 = Session.getDefaultInstance(props2);

        try {

            Store store = session2.getStore("imaps");
            store.connect(this.receivingHost, this.userName, this.password);
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message message[] = folder.getMessages();
            for (int i = 0; i < message.length; i++) {
                System.out.println(message[i].getSubject());
            }
            folder.close(true);
            store.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {

        String mailFrom = new String("eleganinfo@gmail.com");
        String mailTo = new String("isanhot@ra.rockwell.com");
        String senderPassword = new String("foxpro123");
        String senderUserName = new String("eleganinfo");
        String mailSubject = new String("Testing Mail");
        String mailText = new String("Test Email received...");
        SendEmailClient newGmailClient = new SendEmailClient();
        newGmailClient.setAccountDetails(senderUserName, senderPassword);
        newGmailClient.sendGmail(mailFrom, mailTo, mailSubject, mailText);

//Receive mails
//        newGmailClient.readGmail();

    }

}
