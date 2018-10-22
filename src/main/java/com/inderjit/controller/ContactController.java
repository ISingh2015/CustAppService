package com.inderjit.controller;

import com.inderjit.config.MailConfig;
import com.inderjit.forms.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ControllerAdvice
public class ContactController {

    Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Value("${spring.mail.username}")
    private String mailSuperUser;

    @Autowired
    private MailConfig mailConfig;

    @RequestMapping(value = "contact", method = {RequestMethod.GET})
    public String contactInit(Model model) {
        model.addAttribute("contactForm", new UserForm());
        return "home/contact";
    }

    @RequestMapping(value = "contact", method = {RequestMethod.POST})
    @ResponseBody
    public boolean contactAdd(@ModelAttribute("contactName") String contactName,
            @ModelAttribute("contactEmail") String contactEmail,
            @ModelAttribute("contactMobile") String contactMobile,
            @ModelAttribute("contactMessage") String contactMessage) {
        boolean emailSent = false;
        if (contactName != null) {
            emailSent = emailContactMessage(contactName, contactEmail, contactMobile, contactMessage);
        }
        return emailSent;
    }

    private boolean emailContactMessage(String contactName, String contactEmail, String contactMobile, String contactMessage) {
        boolean messageSaved = false;
        try {
            logger.info("Contact Message Sent");
            messageSaved = mailConfig.sendMail(mailSuperUser, mailSuperUser, "Contact Message from " + contactName + " - " + contactMobile + " - " + contactEmail, contactMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        System.out.println("Save contact");
        return messageSaved;
    }

}
