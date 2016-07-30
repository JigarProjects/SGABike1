package com.core;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Jigar on 7/28/2016.
 */
public class configsetup extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("jrtest1245@gmail.com", "j123$$jr"));
        email.setSSLOnConnect(true);
        try {
            email.setFrom("jrtest1245@gmail.com");
            email.setSubject("TestMail");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("jrtest1245@gmail.com");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }



        System.out.println("check the timing bro");
    }

    /*protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }*/
}
