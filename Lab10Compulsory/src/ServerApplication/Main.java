package ServerApplication;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GameServer server = new GameServer();
        try {
            server.start();
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e);
            server.stop();
        }
    }
}