package me.werremeyer;

import me.werremeyer.http.Request;
import me.werremeyer.http.RequestParser;
import me.werremeyer.http.Response;
import me.werremeyer.http.ResponseWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    private final String host;
    private final int port;

    public Server(String host, int port) {
        assert !host.isBlank();
        assert port > 0;

        this.host = host;
        this.port = port;
    }

    public Response handleRequest(Request request) {

        return new Response();
    }

    public void listen() throws IOException {
        try (final ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port:" + port);


            while (true) {
                Socket socket = serverSocket.accept();

                try (final InputStream inputStream = socket.getInputStream()) {

                    byte[] buffer = new byte[1024];
                    int bytesRead = inputStream.read(buffer);

                    String message = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                    final Request request = RequestParser.Parse(message);

                    try (OutputStream outputStream = socket.getOutputStream()) {
                        ResponseWriter.WriteResponse(outputStream, new Response());
                    }
                } catch (InvalidRequestException e) {
                    throw new RuntimeException(e);
                }

                socket.close();
            }
        }
    }
}
