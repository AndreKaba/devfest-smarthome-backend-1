package com.vires.sensorapi;

import com.google.api.server.spi.config.Api;
import static com.googlecode.objectify.ObjectifyService.ofy;


/**
 * Created by Ondřej on 12.11.2015.
 */

@Api(name = "senzors",
        version = "v1",
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
public class SenzorEndpoint {

}
