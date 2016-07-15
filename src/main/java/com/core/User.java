package com.core;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jigar on 7/10/2016.
 */

@XmlRootElement
public class User {
    private int id;
    private int userid;
    private String name;

    User() {
        super();
    }

    public User(int id, int userid, String name) {
        this.id = id;
        this.userid = userid;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + id;
    }
}
