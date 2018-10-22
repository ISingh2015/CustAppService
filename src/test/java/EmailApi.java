
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inderjit Singh Sanhotra
 */
public class EmailApi {

    private static final Logger LOGGER = Logger.getLogger(EmailApi.class.getName());

    public static void main(String... args) {

        LOGGER.log(Level.INFO, "Starting Email Application");
        EmailApi emailApi = new EmailApi();

        //sending a plain text email to an outside resource, 
        //with a disclaimer added at the end, unencrypted and no retry
        Email email = emailApi.createEmail("text", "NONE", false, "test@tom.com", "test1@tom.com", "test sub1", "test message1");
        email.setRetry(false);
        try {
            PublicEmailSmtp publicEmail = emailApi.createPublicEmail();

            publicEmail.sendEmail(email);
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }
        LOGGER.log(Level.INFO,"************** Case 1 End ********************");

        //sending an HTML email to an internal server (so without the disclaimer), 
        //encrypted with DES, with the retry functionality        
        email = emailApi.createEmail("html", "DES", true, "test2@tom.com", "test3@tom.com", "test sub2", "test message2");
        email.setRetry(true);
        try {
            InternalEmailSmtp internalEmail = emailApi.createInternalEmail();
            internalEmail.sendEmail(email);
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }
        LOGGER.log(Level.INFO,"************** Case 2 End ********************");
        //sending an HTML email to an outside resource, 
        //with a disclaimer added at the end and encrypted with AES with retries in case of errors        
        email = emailApi.createEmail("html", "AES", true, "test4@tom.com", "test5@tom.com", "test sub3", "test message3");
        email.setRetry(true);
        try {
            PublicEmailSmtp publicEmail = emailApi.createPublicEmail();
            publicEmail.sendEmail(email);
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }
        LOGGER.log(Level.INFO,"************** Case 3 End ********************");

        //sending a plain text email to an outside resource 
        //and encrypted first with DES and then with AES
        email = emailApi.createEmail("text", "NONE", false, "test6@tom.com", "test7@tom.com", "test sub4", "test message4");
        email.setRetry(false);
        email.encryptMessage("DES");
        email.encryptMessage("AES");
        try {
            PublicEmailSmtp publicEmail = emailApi.createPublicEmail();
            publicEmail.sendEmail(email);
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }
        LOGGER.log(Level.INFO,"************** Case 4 End ********************");

    }

    private Email createEmail(String emailType, String encryptType, boolean addDisclaimer, String from, String to, String sub, String message) {
        return new Email(emailType, encryptType, addDisclaimer, from, to, sub, message);
    }

    private InternalEmailSmtp createInternalEmail() {
        return new InternalEmailSmtp();
    }

    private PublicEmailSmtp createPublicEmail() {
        return new PublicEmailSmtp();
    }

    /**
     * interface starts here
     */
    public interface EmailService {

        void sendEmail(Email email);
    }

    /**
     * Email Class Starts here
     */
    public class Email {

        private String emailType, encryptType, emailFrom, emailTo, emailSub, emailMessage;
        private boolean addDisclaimer;
        private boolean retry;

        /**
         * Email VO used to create an email message
         *
         * @param emailType = TEXT or HTML
         * @param encryptType = NONE, AES, DES
         * @param addDisclaimer = disclaimer Text
         * @param emailFrom = email from address. e.g:testuser@compdomain.com
         * @param emailTo= email from address. e.g:testuser1@compdomain.com
         * @param emailSub = email subject line Text
         * @param emailMessage = email Message Text. This is encrypted as
         * encryptType to [NONE, AES, MD5 encryption]
         */
        Email(String emailType, String encryptType, boolean addDisclaimer, String emailFrom, String emailTo, String emailSub, String emailMessage) {
            this.emailType = emailType; // can be TEXT or HTML
            this.encryptType = encryptType; // can be MD5 or AES or BOTH in any order
            this.emailFrom = emailFrom;
            this.emailTo = emailTo;
            this.emailSub = emailSub;
            this.emailMessage = emailMessage;
            if (addDisclaimer) {
                this.addDisclaimer=addDisclaimer;
                this.emailMessage += addDisclaimer();
            }
            if (!encryptType.equalsIgnoreCase("NONE")) {
                this.emailMessage += encryptMessage(encryptType);
            }
        }

        private String addDisclaimer() {
            LOGGER.log(Level.INFO, "Adding Disclaimer");
            String disclaimerString = "Disclaimer Text Added";
            return disclaimerString;
        }

        private String encryptMessage(String typeRequired) {
            EncryptEmailMessage encryptMessage = encryptMessage = new EncryptEmailMessage(this.emailMessage);
            String encryptedMessage = " ";
            if (typeRequired.equalsIgnoreCase("DES")) {
                encryptedMessage = encryptMessage.encryptMessage("DES");
            } else if (typeRequired.equalsIgnoreCase("AES")) {
                encryptedMessage = encryptMessage.encryptMessage("AES");
            } else if (typeRequired.equalsIgnoreCase("BOTH")) {
                encryptedMessage = encryptMessage.encryptMessage("BOTH");
            }
            LOGGER.log(Level.INFO, this.emailMessage + " " + encryptedMessage);
            return encryptedMessage;
        }

        /**
         * @return the emailType
         */
        public String getEmailType() {
            return emailType;
        }

        /**
         * @param emailType the emailType to set
         */
        public void setEmailType(String emailType) {
            this.emailType = emailType;
        }

        /**
         * @return the encryptType
         */
        public String getEncryptType() {
            return encryptType;
        }

        /**
         * @param encryptType the encryptType to set
         */
        public void setEncryptType(String encryptType) {
            this.encryptType = encryptType;
        }

        /**
         * @return the emailFrom
         */
        public String getEmailFrom() {
            return emailFrom;
        }

        /**
         * @param emailFrom the emailFrom to set
         */
        public void setEmailFrom(String emailFrom) {
            this.emailFrom = emailFrom;
        }

        /**
         * @return the emailTo
         */
        public String getEmailTo() {
            return emailTo;
        }

        /**
         * @param emailTo the emailTo to set
         */
        public void setEmailTo(String emailTo) {
            this.emailTo = emailTo;
        }

        /**
         * @return the emailSub
         */
        public String getEmailSub() {
            return emailSub;
        }

        /**
         * @param emailSub the emailSub to set
         */
        public void setEmailSub(String emailSub) {
            this.emailSub = emailSub;
        }

        /**
         * @return the emailMessage
         */
        public String getEmailMessage() {
            return emailMessage;
        }

        /**
         * @param emailMessage the emailMessage to set
         */
        public void setEmailMessage(String emailMessage) {
            this.emailMessage = emailMessage;
        }

        /**
         * @return the retry
         */
        public boolean isRetry() {
            return retry;
        }

        /**
         * @param retry the retry to set
         */
        public void setRetry(boolean retry) {
            this.retry = retry;
        }

    }

    /**
     * Sends a Internal Email to SMTP Server
     */
    class InternalEmailSmtp implements EmailService {

        @Override
        public void sendEmail(Email email) {
            // retry send email if failing 3 times
            for (int sendCnt = 1; sendCnt <= 3; sendCnt++) {
                if (doSendEmail(email) || !email.isRetry()) {
                    break;
                }
            }
        }

        boolean doSendEmail(Email email) {
            LOGGER.log(Level.INFO, "Trying to Send Internal Email.." + email.getEmailType() + " - Retry " + email.isRetry() + " - " + email.getEmailFrom() + " - " + email.getEmailTo() + " - " + email.getEmailMessage()  );
            return true;
        }

    }

    /**
     * Sends a External Email to SMTP Server
     *
     */
    class PublicEmailSmtp implements EmailService {

        @Override
        public void sendEmail(Email email) {
            // retry send email if failing 
            for (int sendCnt = 1; sendCnt <= 3; sendCnt++) {
                if (doSendEmail(email) || !email.isRetry()) {
                    break;
                }
            }
        }

        synchronized boolean doSendEmail(Email email) {
            LOGGER.log(Level.INFO, "Trying to Send External Email.." + email.getEmailType() + " - retry " + email.isRetry() + " - " + email.getEmailFrom() + " - " + email.getEmailTo() + " - " + email.getEmailMessage());
            return true;
        }

    }

    class EncryptEmailMessage {

        private String key = "newEncryptKey", message;

        EncryptEmailMessage(String message) {
            this.message = message;
        }

        public String encryptMessage(String type) {
            return doEncryption(type);
        }

        public String doEncryption(String type) {
            //encrypt message with AES of DES using key 
            if (type.equalsIgnoreCase("NONE")) {
                return "Encryption NONE";
            } else if (type.equalsIgnoreCase("DES")) {
                return "DES Encrypted Message";
            } else if (type.equalsIgnoreCase("AES")) {
                return "AES Encrypted Message";
            } else if (type.equalsIgnoreCase("BOTH")) {
                return "AES and DES Encrypted Message";
            }

            return "";
        }
    }
}
