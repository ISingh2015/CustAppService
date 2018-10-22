/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inderjit.config;

//import com.cust.domain.vo.ElegantUser;
//import com.cust.persistance.CustServiceConstants;
//import com.cust.persistance.PersistanceManager;
//import com.cust.persistance.managers.LoginManager;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("loginUserDetailsService")
public class LoginUserDetailService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(LoginUserDetailService.class);

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        ElegantUser elegantUser = null;
//        List<GrantedAuthority> listAuths = new ArrayList<>();
//        try {
//            String s = CustServiceConstants.URL;
//            PersistanceManager.getInstance().setLoginServer(s);
//
//            LoginManager loginManager = new LoginManager();
//            loginManager.getPreferenceList();
//            ArrayList<ElegantUser> userList = loginManager.getUserByName(userName);
//            elegantUser = !userList.isEmpty() ? userList.get(0) : null;
//            if (elegantUser != null) {
//                listAuths.add(new SimpleGrantedAuthority(elegantUser.getRole()));
//                logger.info("user Logged In: " + elegantUser.getUserLoginName()  + " Status " + elegantUser.getAccountStatus());
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//        return buildUserForAuthentication(elegantUser, listAuths);
//    }
//
//    private User buildUserForAuthentication(ElegantUser elegantUser, List<GrantedAuthority> authorities) {
//        return new User(elegantUser.getUserLoginName(), elegantUser.getUserLoginPwd(),
//                (elegantUser.getAccountStatus() == 1 ? true : false), true, true, true, authorities);
//    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
