package com.vires.sensorapi.data.sensors;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * @author Filip Prochazka (jacktech24)
 */

@Entity
public class FlowerSensor {

    @Id
    private Long id;
    private String name;
    private String place;

    public FlowerSensor() {
    }

    public FlowerSensor(String name, String place) {
        this.name = name;
        this.place = place;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
