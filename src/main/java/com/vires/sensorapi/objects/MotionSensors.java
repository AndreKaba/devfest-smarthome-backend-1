package com.vires.sensorapi.objects;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 @author Ondrej Kaba (AndreKaba)
 */
@Entity
public class MotionSensors {

    @Id
    private Long id;
    private Long sensor;
    private Long timestamp;

    public MotionSensors() {
    }

    public MotionSensors(Long sensor, Long timestamp) {
        this.sensor = sensor;
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}