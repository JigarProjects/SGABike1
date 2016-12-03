package com.core;

import com.db.UserDAO;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.util.*;

/**
 * Created by Jigar on 7/30/2016.
 */
public class EmailTask extends TimerTask {
    Date now;

    @Override
    public void run() {
        now = new Date();
        System.out.println("Running at " + now);
        //Step 1 : get the users
        UserDAO userDAO = new UserDAO();
        ArrayList<User> usersToNotify = userDAO.notifyUsers();
        PropertyProvider pr = PropertyProvider.getInstance();
        //Step 2 : get template
        //VelocityEngine velocityEngine =  new VelocityEngine();
        System.out.println("path is :" + pr.getPropertyMap().get("path"));
        Properties p = new Properties();
        p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, pr.getPropertyMap().get("path"));
        Velocity.init(p);

        Template template = Velocity.getTemplate("template/notifyForExpiry.vm");

        //Step 3 : send email
        Iterator<User> itrUser = usersToNotify.iterator();
        User tempUser = null;
        while (itrUser.hasNext()) {
            tempUser = itrUser.next();
            //load email
            VelocityContext velocityContext = new VelocityContext();
            velocityContext.put("username", tempUser.getName());
            StringWriter writer = new StringWriter();
            template.merge(velocityContext, writer);
            //sent to specific user
            EmailHandler emailHandler = EmailHandler.getInstance();
            emailHandler.sendMail(tempUser.getEmailID(), writer.toString());
            System.out.println("Email sent to "+tempUser.getEmailID());
        }
        System.out.println("Job executed");

    }
}
