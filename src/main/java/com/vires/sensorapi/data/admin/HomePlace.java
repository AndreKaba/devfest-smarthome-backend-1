package com.vires.sensorapi.data.admin;

import com.google.appengine.repackaged.com.google.type.LatLng;
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
    private LatLng location;

    public HomePlace() {
    }

    public HomePlace(String name, LatLng location) {
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

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
