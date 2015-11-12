package com.vires.sensorapi;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * @author Filip Prochazka (jacktech24)
 */
@Entity
public class SensorData {


    @Id
    public Long id;
    public Float number;
}
