package com;


import org.apache.log4j.Logger;

/**
 * Created by Jigar on 6/29/2016.
 */
public class SGALogger {
    public static Logger _log = null;
    static {
        _log = Logger.getLogger(SGALogger.class.getName());
        _log.debug("Single Intialization");
    }
    public SGALogger(){
        _log.debug("Called this class");
    }
}
