package com.vires.sensorapi.objects;

import com.vires.sensorapi.data.sensor_data.PowerConsumption;

import java.util.Collections;
import java.util.List;

/**
 * @author Filip Prochazka (jacktech24)
 */
public class SensorPowerConsumption {

    private Float totalConsumption;
    private Long dateFrom;
    private Long dateTo;

    private SensorPowerConsumption(List<PowerConsumption> list) {
        Collections.sort(list);

    }

    public static SensorPowerConsumption from(List<PowerConsumption> sensors) {
        return new SensorPowerConsumption(sensors);
    }

    public Float getTotalConsumption() {
        return totalConsumption;
    }

    public Long getDateFrom() {
        return dateFrom;
    }

    public Long getDateTo() {
        return dateTo;
    }
}
