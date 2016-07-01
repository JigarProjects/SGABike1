package com.db;

import com.SGALogger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by Jigar on 6/28/2016.
 */
public class DAOBase extends SGALogger {
    private static DataSource _ds = null;
    private static DAOBase instance = null;


     DAOBase() {
         super();
         Context initContext = null;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            _ds = (DataSource) envContext.lookup("jdbc/jigarDB");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private static DAOBase getInstance(){
        if(instance == null) {
            instance = new DAOBase();
            System.out.println("One time call only .");
            _log.debug("test");

        }
        return instance;
    }

    public static Connection getConnection() {
        DAOBase.getInstance();
        Connection cn = null;
        try {
            cn = _ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }



}
