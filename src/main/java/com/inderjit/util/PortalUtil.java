/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inderjit.util;

import java.text.SimpleDateFormat;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;

/**
 *
 * @author Zed
 */
public class PortalUtil {

    private static final String copyRightYear = new SimpleDateFormat("yyyy").format(new Date());
    private static final String copyRight = "\u00a9 " + new SimpleDateFormat("yyyy").format(new Date()) + " inderjitportal.com";

    public static void addAttributesToSession(ModelAndView mav) {
        mav.addObject("copyrightyear", copyRightYear);        
        mav.addObject("today", new Date());
        mav.addObject("copyrightmessage", copyRight);
    }

}
