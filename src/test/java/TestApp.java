
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zed
 */
public class TestApp {
    public static void main (String ... args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        CharSequence csc = "finder2018";
        System.out.println(encoder.encode(csc));
        
    }
}
