package com.vires.sensorapi.data.sensor_data;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * @author Ondrej Kaba (AndreKaba)
 * @author Filip Prochazka (jacktech24)
 */
@Entity
public class MotionDetection {

    @Id
    private Long id;
    private Long sensor;
    private Long timestamp;

    public MotionDetection() {
    }

    public MotionDetection(Long sensor, Long timestamp) {
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
