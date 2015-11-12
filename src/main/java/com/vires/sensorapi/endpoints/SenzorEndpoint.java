package com.vires.sensorapi.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.vires.sensorapi.util.Constants;
import com.vires.sensorapi.objects.*;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;


/**
 * @author Ondrej Kaba (AndreKaba)
 */

@Api(name = "senzors",
        version = "v1",
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
public class SenzorEndpoint {
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
    public Float retrieveConsumtion(Long sensor){
        List<PowerConsumption> sensors = ofy().load().type(PowerConsumption.class).filter("sensor",sensor).list();
        Float sum = (float) 0;
        for(int i = 0; i< sensors.size();i++){
            sum += sensors.get(i).getConsumption();
        }
        return sum / sensors.size();
    }

    @ApiMethod
    public Float retrieveOverallConsumtion() {
        List<PowerConsumption> sensors = ofy().load().type(PowerConsumption.class).list();
        Float sum = (float) 0;
        for (int i = 0; i < sensors.size(); i++) {
            sum += sensors.get(i).getConsumption();
        }
        return sum / sensors.size();
    }

}
