package com.vires.sensorapi;

import com.googlecode.objectify.ObjectifyService;
import com.vires.sensorapi.objects.FlowerData;
import com.vires.sensorapi.objects.MotionSensors;
import com.vires.sensorapi.objects.PowerConsumption;
import com.vires.sensorapi.objects.WeatherData;

import javax.servlet.http.HttpServlet;

/**
 * Created by jacktech24 on 7.11.15.
 */
public class StartupServlet extends HttpServlet {

    static {
        ObjectifyService.register(SensorData.class);
        ObjectifyService.register(WeatherData.class);
        ObjectifyService.register(FlowerData.class);
        ObjectifyService.register(MotionSensors.class);
        ObjectifyService.register(PowerConsumption.class);
    }

}
