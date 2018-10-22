
package com.inderjit.controller;

//import com.cust.domain.vo.ElegantUser;
//import com.cust.persistance.CustServiceConstants;
//import com.cust.persistance.PersistanceManager;
//import com.cust.persistance.managers.LoginManager;
import com.inderjit.config.MailConfig;
import com.inderjit.forms.UserForm;
import com.inderjit.util.PortalUtil;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForgotPasswordController {

    Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Value("${spring.mail.username}")
    private String mailSuperUser;

    @Autowired
    private MailConfig mailConfig;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "forgotPassword", method = RequestMethod.GET)
    public ModelAndView forgotPasswordInt() {
        ModelAndView mav = new ModelAndView("home/forgotPassword", "passwordForm", new UserForm());
        PortalUtil.addAttributesToSession(mav);
        return mav;
    }

    @RequestMapping(value = "forgotPassword", method = RequestMethod.POST)
    @ResponseBody
    public boolean forgotPasswordSend(@ModelAttribute("userLoginName") String userLoginName, @ModelAttribute("password") String password) {
        boolean saved = false;
//        ElegantUser elegantUser = null;
//        try {
//            String s = CustServiceConstants.URL;
//            PersistanceManager.getInstance().setLoginServer(s);
//
//            LoginManager loginManager = new LoginManager();
//            loginManager.getPreferenceList();
//            ArrayList<ElegantUser> userList = loginManager.getUserByName(userLoginName);
//            elegantUser = !userList.isEmpty() ? userList.get(0) : null;
//            if (elegantUser != null) {
//                boolean sent = mailConfig.sendMail(mailSuperUser, elegantUser.getEmailId(), "Reset Password", "Your Password has been reset to " + password);
//                if (sent)  {
//                    String pwd = passwordEncoder.encode(password);
//                    elegantUser.setUserLoginPwd(pwd);
//                    loginManager.doSaveUserLogin(elegantUser);
//                }
//                saved=sent;
//            } else {
//                
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
        return saved;
    }
    
}
