package com.core;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Map;

/**
 * Created by Jigar on 7/30/2016.
 */
public class EmailHandler {
    private static EmailHandler ourInstance = new EmailHandler();
    int _smtpport;
    String _username;
    String _password;
    String _from;
    String _time;
    String _path;
    private String _hostname;
    private EmailHandler() {
        //load one time setting username/password/emailid/mail setting
        PropertyProvider pr = PropertyProvider.getInstance();
        Map<String, String> propertyMap = pr.getPropertyMap();

        _hostname = propertyMap.get("mailhostname");
        _smtpport = Integer.parseInt(propertyMap.get("smtpport"));

        _username = propertyMap.get("username");
        _password = propertyMap.get("password");

        _from = propertyMap.get("username");
        _time = propertyMap.get("time");

        /*String subject = "TestMail";
        String msg = "This is a test mail ... :-)";
        String to = "jrtest1245@gmail.com";*/

    }

    public static EmailHandler getInstance() {
        return ourInstance;
    }

    public int sendMail(String to, String msg) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName(_hostname);
            email.setSmtpPort(_smtpport);
            email.setAuthenticator(new DefaultAuthenticator(_username, _password));
            email.setSSLOnConnect(true);
            email.setFrom(_from);

            //email content
            email.addTo(to);
            email.setSubject("SGA Notification");
            email.setHtmlMsg(msg);

            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
