package me.werremeyer.http;

import me.werremeyer.InvalidRequestException;

public enum Method {
    GET,
    POST,
    PUT,
    PATCH,
    DELETE,
    HEAD,
    CONNECT,
    OPTIONS,
    TRACE;

    public static Method From(String s) throws InvalidRequestException {
        return switch (s) {
            case "GET" -> Method.GET;
            case "POST" -> Method.POST;
            case "PUT" -> Method.PUT;
            case "PATCH" -> Method.PATCH;
            case "DELETE" -> Method.DELETE;
            case "HEAD" -> Method.HEAD;
            case "CONNECT" -> Method.CONNECT;
            case "OPTIONS" -> Method.OPTIONS;
            case "TRACE" -> Method.TRACE;
            default -> throw new InvalidRequestException("Unexpected http method: " + s);
        };
    }
}


