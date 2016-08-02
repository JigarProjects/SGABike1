package com.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Timer;

/**
 * Created by Jigar on 7/31/2016.
 */
public class PropertyProvider {

    private static PropertyProvider ourInstance = new PropertyProvider();

    public static PropertyProvider getInstance() {
        return ourInstance;
    }

    private HashMap<String,String> configurationMap = new HashMap<>();


    private PropertyProvider() {
        InputStream inputStream = null;
        try {

            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            //Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            configurationMap.put("mailhostname",prop.getProperty("hostname"));
            configurationMap.put("smtpport",prop.getProperty("smtpport"));
            configurationMap.put("username",prop.getProperty("username"));
            configurationMap.put("password",prop.getProperty("password"));
            configurationMap.put("subject",prop.getProperty("subject"));
            configurationMap.put("time",prop.getProperty("time"));
            //Email Scheduler
            String timeInHour = prop.getProperty("time");

            Timer time = new Timer();
            //time.schedule(st, 0, 1000);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public HashMap<String,String> getPropertyMap(){
        return configurationMap;
    }
    public void addToMap(String key, String value){
        configurationMap.put(key,value);
    }
}
