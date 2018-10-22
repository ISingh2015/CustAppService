package com.inderjit.controller;

//import com.cust.domain.vo.ElegantUser;
//import com.cust.persistance.managers.LoginManager;
import com.inderjit.forms.UserForm;
import com.inderjit.util.PortalUtil;
import com.inderjit.validators.LoginUserValidator;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    Logger logger = LoggerFactory.getLogger(RegistrationController.class);    

    @Autowired
    private LoginUserValidator userValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    private final LoginManager loginManager = new LoginManager();
    
    @RequestMapping(value = "register", method = {RequestMethod.GET})
    public ModelAndView registerInit() {
        ModelAndView mav = new ModelAndView("register", "registerForm", new UserForm());
        PortalUtil.addAttributesToSession(mav);
        return mav;
    }

    @RequestMapping(value = "register", method = {RequestMethod.POST})
    public ModelAndView registerAdd(@ModelAttribute("registerForm") UserForm registerForm, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("register", "registerForm", registerForm);
        userValidator.validate(registerForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return mav;
        }
//        if (registerUser(registerForm.getNewUser())) {
//            autologin(registerForm.getNewUser().getUserLoginName(), registerForm.getNewUser().getUserLoginPwd());
//            mav.setViewName("home");
//            return mav;
//        }
        mav.addObject("registerForm", new UserForm());
        mav.addObject("successMessage", "User Added Successfully");
        mav.setViewName("register");
        return mav;
    }

//    private boolean registerUser(ElegantUser user) {
//        boolean registered = false;
//        try {
//            ArrayList<ElegantUser> userList = new ArrayList<>();
//            if (user.getCompID() == 0) {
//                user.setCompID(9999);
//                String pwd = passwordEncoder.encode(user.getUserLoginPwd());
//                user.setUserLoginPwd(pwd);
//            }
//            userList.add(user);
//            loginManager.saveUserList(userList, false);
//            logger.info("Registered User " + user.getUserLoginName());
//            registered = true;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//        return registered;
//    }

}
