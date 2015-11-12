package com.vires.sensorapi;

import com.googlecode.objectify.ObjectifyService;
import com.vires.sensorapi.objects.FLowerData;
import com.vires.sensorapi.objects.WeatherData;

import javax.servlet.http.HttpServlet;

/**
 * Created by jacktech24 on 7.11.15.
 */
public class StartupServlet extends HttpServlet {

    static {
        ObjectifyService.register(SensorData.class);
        ObjectifyService.register(WeatherData.class);
        ObjectifyService.register(FLowerData.class);
    }

}
