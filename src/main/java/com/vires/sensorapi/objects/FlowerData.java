package com.vires.sensorapi.objects;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * @author Ondrej Kaba (AndreKaba)
 */
@Entity
public class FlowerData {

    @Id
    private Long id;
    private Long flower;
    private Float humidity;

    public FlowerData() {
    }

    public FlowerData(Long flower, Float humidity) {
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
