package com.vires.sensorapi.data.sensor_data;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.vires.sensorapi.data.sensors.PowerConsumptionSensor;

/**
 * @author Ondrej Kaba (AndreKaba)
 * @author Filip Prochazka (jacktech24)
 */
@Entity
public class PowerConsumption implements Comparable<PowerConsumption> {

    @Id
    private Long id;
    private Ref<PowerConsumptionSensor> sensor;
    private Float consumption;
    private Long timestamp;

    public PowerConsumption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PowerConsumptionSensor getSensor() {
        return sensor.get();
    }

    public void setSensor(PowerConsumptionSensor sensor) {
        this.sensor = Ref.create(sensor);
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
