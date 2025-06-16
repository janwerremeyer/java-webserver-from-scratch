package me.werremeyer;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final Server server = new Server("127.0.0.1", 8080);
        server.listen();
    }


}