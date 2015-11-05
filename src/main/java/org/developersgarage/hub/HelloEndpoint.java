package org.developersgarage.hub;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

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

}
