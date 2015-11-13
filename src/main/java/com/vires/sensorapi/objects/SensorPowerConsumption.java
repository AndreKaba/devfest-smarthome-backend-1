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
        setDateFrom(Long.MAX_VALUE);
        setDateFrom(Long.MIN_VALUE);
        Float cons = (float) 0;
        for(int i = 0; i<list.size(); i++){
            if (list.get(i).getTimestamp()<dateFrom) setDateFrom(list.get(i).getTimestamp());
            if (list.get(i).getTimestamp()>dateTo) setDateTo(list.get(i).getTimestamp());
            cons += list.get(i).getConsumption();
        }
        setTotalConsumption((cons/list.size())*(dateTo-dateFrom)*3600000); // recorded consumption / number of entries - avg consumption
    }                                                                      // *seconds in timespan (J) -> *3600000 (KWh)

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

    public void setTotalConsumption(Float totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    public void setDateFrom(Long dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Long dateTo) {
        this.dateTo = dateTo;
    }
}
