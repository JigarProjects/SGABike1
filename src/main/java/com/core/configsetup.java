package com.core;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;


/**
 * Created by Jigar on 7/28/2016.
 */
public class configsetup extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        //Setup scheduler in java
        PropertyProvider pr = PropertyProvider.getInstance();


        String time = pr.getPropertyMap().get("time");

        String[] timeArray = time.split(":");


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        /*System.out.println("timer : "+time+ " : "+cal.getTime());
        cal.set(Calendar.HOUR, Integer.parseInt(timeArray[0]));
        cal.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));*/

        ServletConfig conf = getServletConfig();
        String path = conf.getServletContext().getRealPath("/");
        pr.addToMap("path", path);

        System.out.println("intializing schedulers " + cal.getTime());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new EmailTask(), cal.getTime(), 24 * 60 * 60 * 1000);
        // hour, min, second, millisecon


    }

    /*protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }*/
}
