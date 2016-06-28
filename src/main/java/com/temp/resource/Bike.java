package com.temp.resource;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jigar on 4/9/2016.
 */

@XmlRootElement
@Entity
@Table(name = "BIKE")
public class Bike {
    //proper uuid support
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    @Column(name="NAME")
    String name;
    @Column(name="DESCRIPTION")
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


}
