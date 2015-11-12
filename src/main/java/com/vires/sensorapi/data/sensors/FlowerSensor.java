package com.vires.sensorapi.data.sensors;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.vires.sensorapi.data.admin.HomePlace;

/**
 * @author Filip Prochazka (jacktech24)
 */

@Entity
public class FlowerSensor {

    @Id
    private Long id;
    private Ref<HomePlace> place;
    private String name;
    private String location;

    public FlowerSensor() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPlace(HomePlace place) {
        this.place = Ref.create(place);
    }

    public HomePlace getPlace() {
        return place.get();
    }
}
