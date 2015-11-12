package com.vires.sensorapi.data.admin;

import com.google.appengine.api.datastore.GeoPt;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * @author Filip Prochazka (jacktech24)
 */
@Entity
public class HomePlace {

    @Id
    private Long id;
    private String name;
    private GeoPt location;

    public HomePlace() {
    }

    public HomePlace(String name, GeoPt location) {
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoPt getLocation() {
        return location;
    }

    public void setLocation(GeoPt location) {
        this.location = location;
    }
}
