package com.vires.sensorapi.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.vires.sensorapi.data.sensor_data.FlowerData;
import com.vires.sensorapi.data.sensor_data.MotionSensors;
import com.vires.sensorapi.data.sensor_data.PowerConsumption;
import com.vires.sensorapi.data.sensor_data.WeatherData;
import com.vires.sensorapi.util.Constants;
import com.vires.sensorapi.objects.*;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;


/**
 * @author Ondrej Kaba (AndreKaba)
 * @author Filip Prochazka (jacktech24)
 */

@Api(name = "data",
        version = "v1",
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
public class DataEndpoint {
    @ApiMethod
    public Response weatherInfo(WeatherData data){
        try {
            ofy().save().entity(data).now();
            return new Response(true);
        } catch (Exception e){
            return new Response(false);
        }
    }

    @ApiMethod
    public List<WeatherData> retrieveWeatherInfo(){
        return ofy().load().type(WeatherData.class).list();
    }

    @ApiMethod
    public Response flowerInfo(FlowerData data){
        try{
            ofy().save().entity(data).now();
            return new Response(true);
        } catch (Exception e){
            return new Response(false);
        }
    }

    @ApiMethod
    public List<FlowerData> retrieveFlowerInfo(){
        return ofy().load().type(FlowerData.class).list();
    }

    @ApiMethod
    public Response motionInfo(MotionSensors data){
        try{
            ofy().save().entity(data).now();
            return new Response(true);
        } catch (Exception e){
            return new Response(false);
        }
    }

    @ApiMethod
    public List<MotionSensors> retrieveMotionInfo(){
        return ofy().load().type(MotionSensors.class).list();
    }

    @ApiMethod
    public Response consumptionInfo(PowerConsumption data){
        try{
            ofy().save().entity(data).now();
            return new Response(true);
        } catch (Exception e){
            return new Response(false);
        }
    }

    @ApiMethod
    public SensorPowerConsumption retrieveConsumtion(@Named Long sensor){
        List<PowerConsumption> sensors = ofy().load().type(PowerConsumption.class).filter("sensor", sensor).list();
        return SensorPowerConsumption.from(sensors);
    }
    
}
