package com.vires.sensorapi.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.vires.sensorapi.Constants;
import com.vires.sensorapi.objects.Responds;
import com.vires.sensorapi.objects.WeatherData;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;


/**
 * @author Okaba
 */

@Api(name = "senzors",
        version = "v1",
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
public class SenzorEndpoint {
    @ApiMethod
    public Responds weatherInfo(WeatherData data){
        try {
            ofy().save().entity(data).now();
            return new Responds(true);
        } catch (Exception e){
            return new Responds(false);
        }
    }

    @ApiMethod
    public List<WeatherData> retrieveWeatherInfo(){
        return ofy().load().type(WeatherData.class).list();
    }
}
