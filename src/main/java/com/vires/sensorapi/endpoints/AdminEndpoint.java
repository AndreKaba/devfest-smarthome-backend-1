package com.vires.sensorapi.endpoints;

import com.google.api.server.spi.config.Api;
import com.vires.sensorapi.util.Constants;

/**
 * @author Filip Prochazka (jacktech24)
 */

@Api(name = "admin",
        version = "v1",
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
public class AdminEndpoint {
}
