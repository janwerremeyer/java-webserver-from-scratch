package me.werremeyer.http;

import me.werremeyer.InvalidRequestException;

import java.io.IOException;

public class RequestParser {

    //GET / HTTP/1.1
    public static Request ParseFirstLine(String line) throws InvalidRequestException {
        final String[] requestStart = line.split(" ");

        if (requestStart.length != 3) {
            throw new InvalidRequestException("Could not identify http protocol");
        }

        final Method method = Method.From(requestStart[0]);

        final String path = requestStart[1];

        final String protocol = requestStart[2];
        if (!protocol.equals("HTTP/1.1")) {
            throw new InvalidRequestException("Unsupported protocol:" + protocol);
        }

        return new Request(method, path, protocol);


    }

    public static Request Parse(String rawHttpRequest) throws IOException, InvalidRequestException {

        final Request request = ParseFirstLine(rawHttpRequest.split("\n", 2)[0]);

        return request;
    }
}
