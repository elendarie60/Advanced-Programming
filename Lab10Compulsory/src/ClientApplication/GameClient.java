package ClientApplication;

import java.io.*;
import java.net.*;

public class GameClient {
    private static final String SERVER_ADDRESS = "localhost"; // Change this to the server's IP if needed
    private static final int SERVER_PORT = 12345; // Same port as the server

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server. Type 'exit' to quit.");

            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine);
                if (userInputLine.equals("exit")) {
                    break;
                }
                System.out.println("Server response: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
