package com.vires.sensorapi;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by jacktech24 on 18.10.15.
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
