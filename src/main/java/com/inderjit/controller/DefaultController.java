package com.inderjit.controller;

import com.inderjit.util.PortalUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

    Logger logger = LoggerFactory.getLogger(DefaultController.class);
    private static final int DEFAULT_BUFFER_SIZE = 10240;
//    private final LoginManager loginManager = new LoginManager();

    public DefaultController() {
//        String s = CustServiceConstants.URL;
//        PersistanceManager.getInstance().setLoginServer(s);
//
//        loginManager.getPreferenceList();

    }

    @GetMapping(value = {"/", "home"})
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home/home_angular");
        PortalUtil.addAttributesToSession(mav);
        return mav;
    }

    @GetMapping("admin")
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("user")
    public String user() {
        return "admin/user";
    }

    @GetMapping("about")
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("home/about");
        PortalUtil.addAttributesToSession(mav);
        return mav;
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping(value = {"403"})
    public String error403() {
        return "error/403";
    }

    @GetMapping(value = {"/error"})
    public String errorpg() {
        return "error/error";
    }

    @GetMapping(value = {"/testGames"})
    public String testGamesPage() {
        System.out.println("Loading Games Page");
        return "home/testGames";
    }

    @RequestMapping(value = "pricing", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pricing() {
        ModelAndView mav = new ModelAndView("home/pricing");
        PortalUtil.addAttributesToSession(mav);
        mav.addObject("pricingText", getPricingText());
        return mav;

    }

    private String getPricingText() {
        String benefitText = "Pricing Page. <b>Under Developement</b>";
        return benefitText;
    }

    @RequestMapping(value = "download", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView download(Device device) {
        ModelAndView mav = new ModelAndView("home/download");
        PortalUtil.addAttributesToSession(mav);
        mav.addObject("allowDownload", isAllowDownload(device));
        return mav;
    }

    private boolean isAllowDownload(Device device) {
        return (device.isNormal() ? true : false);
    }

    @RequestMapping(value = "startdownload", method = {RequestMethod.GET, RequestMethod.POST})
    public void startDownload(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("starting download");
        BufferedInputStream input;
        BufferedOutputStream output;

        File file = new File("e:/elegantsetups/ElegantInventory_windows_1_0_0.exe");
        try {
            if (file.exists()) {
                res.setContentType("application/octet-stream");
                res.addHeader("Content-Length", String.valueOf(file.length()));
                res.addHeader("Content-Disposition", "attachment; filename=\"" + "ElegantInventory_windows_1_0_0.exe" + "\"");
                input = new BufferedInputStream(new FileInputStream(file),
                        DEFAULT_BUFFER_SIZE);
                output = new BufferedOutputStream(res.getOutputStream(),
                        DEFAULT_BUFFER_SIZE);
                byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
                input.close();
                output.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
