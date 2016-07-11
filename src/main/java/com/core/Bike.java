package com.core;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jigar on 4/9/2016.
 */

@XmlRootElement
public class Bike {
    //proper uuid support
    int id;
    String name;
    String description;

    public Bike() {
        super();
    }

    public Bike(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " " + description;
    }
}
