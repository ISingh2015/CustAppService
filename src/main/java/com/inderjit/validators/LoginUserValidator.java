/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inderjit.validators;

//import com.cust.domain.vo.ElegantUser;
//import com.cust.persistance.CustServiceConstants;
//import com.cust.persistance.PersistanceManager;
//import com.cust.persistance.managers.LoginManager;
//import com.inderjit.forms.UserForm;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Zed
 */
@Component
public class LoginUserValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(LoginUserValidator.class);
    Pattern pattern;
    Matcher matcher;
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]{8,30}$";
    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String MOBILENO_PATTERN = "^[0-9]{10}$";

    @Override
    public boolean supports(Class<?> aClass) {
//        return ElegantUser.class.equals(aClass);
        return true;
    }

    @Override
    public void validate(Object o, Errors errors) {
//        UserForm registerForm = (UserForm) o;
//        ElegantUser user = null;
//        try {
//            if (registerForm.getNewUser().getUserLoginName() == null || registerForm.getNewUser().getUserLoginName().equals("")) {
//                errors.rejectValue("newUser.userLoginName", null, "User Name is Required");
//            } else {
//                pattern = Pattern.compile(USERNAME_PATTERN);
//                matcher = pattern.matcher(registerForm.getNewUser().getUserLoginName());
//
//                if (!matcher.matches()) {
//                    errors.rejectValue("newUser.userLoginName", null, "8-30 Chars. Any Upper Case and Lower Case and Digit");
//                }
//            }
//
//            if (registerForm.getNewUser().getEmailId() == null || registerForm.getNewUser().getEmailId().equals("")) {
//                errors.rejectValue("newUser.emailId", null, "Email Id is Required");
//            } else {
//                pattern = Pattern.compile(EMAIL_PATTERN);
//                matcher = pattern.matcher(registerForm.getNewUser().getEmailId());
//                if (!matcher.matches()) {
//                    errors.rejectValue("newUser.emailId", null, "Invalid Email Id Entered (e.g. sampe@domain.com)");
//                }
//
//            }
//            if (registerForm.getNewUser().getMobileNo() == null || registerForm.getNewUser().getMobileNo().equals("")) {
//                errors.rejectValue("newUser.mobileNo", null, "Mobile No is Required");
//            } else {
//                pattern = Pattern.compile(MOBILENO_PATTERN);
//                matcher = pattern.matcher(registerForm.getNewUser().getMobileNo());
//                if (!matcher.matches()) {
//                    errors.rejectValue("newUser.mobileNo", null, "10 digits (e.g 8888999900)");
//                }
//            }
//            if (registerForm.getNewUser().getUserLoginPwd() == null || registerForm.getNewUser().getUserLoginPwd().equals("")) {
//                errors.rejectValue("newUser.userLoginPwd", null, "Password is Required");
//                pattern = Pattern.compile(USERNAME_PATTERN);
//                matcher = pattern.matcher(registerForm.getNewUser().getUserLoginPwd());
//
//                if (!matcher.matches()) {
//                    errors.rejectValue("newUser.userLoginPwd", null, "8-30 Chars. Any Upper Case and Lower Case and Digit");
//                }
//
//            }
//            if (!errors.hasErrors()) {
//                String s = CustServiceConstants.URL;
//                PersistanceManager.getInstance().setLoginServer(s);
//
//                LoginManager loginManager = new LoginManager();
//                loginManager.getPreferenceList();
//                ArrayList<ElegantUser> userList = loginManager.getUserByName(registerForm.getNewUser().getUserLoginName());
//                user = !userList.isEmpty() ? userList.get(0) : null;
//
//                if (user != null) {
//                    errors.rejectValue("newUser.userLoginName", null, "Someone has already taken this account");
//                }
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }

    }

}
