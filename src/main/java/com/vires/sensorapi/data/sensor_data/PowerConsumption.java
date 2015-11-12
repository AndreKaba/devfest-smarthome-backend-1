package com.vires.sensorapi.data.sensor_data;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * @author Ondrej Kaba (AndreKaba)
 * @author Filip Prochazka (jacktech24)
 */
@Entity
public class PowerConsumption implements Comparable<PowerConsumption> {

    @Id
    private Long id;
    private Long sensor;
    private Float consumption;
    private Long timestamp;

    public PowerConsumption() {
    }

    public PowerConsumption(Long sensor, Float consumption, Long timestamp) {
        this.sensor = sensor;
        this.consumption = consumption;
        this.timestamp = timestamp;
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

    public Float getConsumption() {
        return consumption;
    }

    public void setConsumption(Float consumption) {
        this.consumption = consumption;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(PowerConsumption o) {
        return timestamp.compareTo(o.getTimestamp());
    }
}
