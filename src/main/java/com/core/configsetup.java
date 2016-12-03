package com.core;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


/**
 * Created by Jigar on 7/28/2016.
 */
public class configsetup extends HttpServlet {
    private static final Timer timer = new Timer();
    @Override
    public void init() throws ServletException {
        super.init();
        //Setup scheduler in java
        PropertyProvider pr = PropertyProvider.getInstance();


        String time = pr.getPropertyMap().get("time");
        String[] timeArray = time.split(":");



        Calendar cal = Calendar.getInstance();
        System.out.println("timer : "+time+ " : "+cal.getTime());
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
        cal.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));

        /*cal.set(Calendar.HOUR, 6);
        cal.set(Calendar.MINUTE, 50);*/

        ServletConfig conf = getServletConfig();
        String path = conf.getServletContext().getRealPath("/");
        pr.addToMap("path", path);

        System.out.println("intializing schedulers " + cal.getTime());

        timer.scheduleAtFixedRate(new EmailTask(), cal.getTime(), 24 * 60 * 60 * 1000);


            // hour, min, second, millisecon

    }
    public void changeNotificationTime(int hour, int minute){
        timer.cancel();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, hour );
        cal.set(Calendar.MINUTE, minute );

        timer.scheduleAtFixedRate(new EmailTask(), cal.getTime() ,24*60*60*1000 );
    }
}
