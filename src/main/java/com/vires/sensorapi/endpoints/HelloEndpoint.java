package com.vires.sensorapi.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.vires.sensorapi.util.Constants;
import com.vires.sensorapi.HelloGreeting;
import com.vires.sensorapi.SensorData;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * @author Filip Prochazka (jacktech24)
 */

@Api(name = "helloworld",
        version = "v1",
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
public class HelloEndpoint {

    @ApiMethod(name = "hello.greeting", path = "hello/greeting", httpMethod = "GET")
    public HelloGreeting greeting() {
        HelloGreeting response = new HelloGreeting("hello world");
        return response;
    }

    @ApiMethod
    public SensorData insertData(SensorData data) {
        ofy().save().entity(data).now();
        return data;
    }

    @ApiMethod
    public List<SensorData> retrieveSensorData() {
        return ofy().load().type(SensorData.class).list();
    }

}
