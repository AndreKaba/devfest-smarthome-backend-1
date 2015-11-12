package com.vires.sensorapi;

import com.googlecode.objectify.ObjectifyService;
import com.vires.sensorapi.data.sensor_data.FlowerData;
import com.vires.sensorapi.data.sensor_data.MotionSensors;
import com.vires.sensorapi.data.sensor_data.PowerConsumption;
import com.vires.sensorapi.data.sensor_data.WeatherData;
import com.vires.sensorapi.data.sensors.FlowerSensor;

import javax.servlet.http.HttpServlet;

/**
 * @author Ondrej Kaba (AndreKaba)
 * @author Filip Prochazka (jacktech24)
 */
public class StartupServlet extends HttpServlet {

    static {
        ObjectifyService.register(WeatherData.class);
        ObjectifyService.register(FlowerData.class);
        ObjectifyService.register(MotionSensors.class);
        ObjectifyService.register(PowerConsumption.class);
        ObjectifyService.register(FlowerSensor.class);
    }

}
