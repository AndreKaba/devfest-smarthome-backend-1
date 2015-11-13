package com.vires.sensorapi.objects;

import com.vires.sensorapi.data.sensor_data.PowerConsumption;

import java.util.Collections;
import java.util.List;

/**
 * @author Filip Prochazka (jacktech24)
 * @author Ondrej Kaba (Okaba)
 */
public class SensorPowerConsumption {

    private Float totalConsumption;
    private Long dateFrom;
    private Long dateTo;

    private SensorPowerConsumption(List<PowerConsumption> list) {
        Collections.sort(list);
        setDateFrom(list.get(0).getTimestamp());
        setDateTo(list.get(list.size()-1).getTimestamp());
        Float consumption = (float) 0;
        for(int i = 0; i<list.size()-1;i++){
            Long timespan = list.get(i+1).getTimestamp()-list.get(i).getTimestamp();
            consumption += (list.get(i).getConsumption()*timespan)/3600000;
        }
        consumption += list.get(list.size()-1).getConsumption()/3600000;
        setTotalConsumption(consumption);
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
