package com.core;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jigar on 7/21/2016.
 */
@XmlRootElement
public class Attachment {
    int userID;
    int bikeID;
    public Attachment(){

    }
    public Attachment(int userID, int bikeID) {
        this.userID = userID;
        this.bikeID = bikeID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }
}
