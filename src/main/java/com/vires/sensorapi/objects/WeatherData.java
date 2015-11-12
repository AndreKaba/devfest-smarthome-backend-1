package com.vires.sensorapi.objects;

import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.sun.javafx.beans.IDProperty;

/**
 * @author OKaba
 */
@Entity
public class WeatherData {

    @Id
    private Long id;
    private Long sensor;
    private Float temperature;
    private Float humidity;

    public WeatherData() {
    }

    public WeatherData(Float temperature, Float humidity, Long sensor){
        this.temperature = temperature;
        this.humidity = humidity;
        this.sensor = sensor;
    }

    public void setTemperature(Float temperature){
        this.temperature = temperature;
    }

    public Float getTemperature(){
        return temperature;
    }

    public void setHumidity(Float humidity){
        this.humidity = humidity;
    }

    public Float getHumidity(){
        return humidity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSensor() {
        return sensor;
    }

    public void setSensor(Long sensor) {
        this.sensor = sensor;
    }
}
