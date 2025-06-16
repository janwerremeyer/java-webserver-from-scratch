package me.werremeyer.http;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ResponseWriter {

    public static void WriteResponse(OutputStream outputStream, Response response) throws IOException {

        StringBuilder builder = new StringBuilder();
        builder.append("HTTP/1.1");
        builder.append(" ");
        builder.append("200");
        builder.append(" ");
        builder.append("OK");
        builder.append("\r\n");
//        builder.append("Content-Length: 100");
        builder.append("\r\n");
        builder.append("<h1>Hello World</h1>");

        outputStream.write(builder.toString().getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
    }
}
