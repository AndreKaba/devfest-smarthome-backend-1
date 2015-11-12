package com.vires.sensorapi.objects;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * @author Okaba
 */
@Entity
public class FLowerData {

    @Id
    private Long id;
    private Long flower;
    private Float humidity;

    public FLowerData() {
    }

    public FLowerData(Long flower, Float humidity) {
        this.flower = flower;
        this.humidity = humidity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlower() {
        return flower;
    }

    public void setFlower(Long flower) {
        this.flower = flower;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }
}
