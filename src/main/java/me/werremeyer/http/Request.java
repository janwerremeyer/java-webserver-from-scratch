package me.werremeyer.http;

import java.io.BufferedReader;
import java.io.IOException;

public class Request {

    private final Method method;
    private final String path;
    private final String protocol;

    public Request(Method method, String path, String protocol) {
        this.method = method;
        this.path = path;
        this.protocol = protocol;
    }
}
