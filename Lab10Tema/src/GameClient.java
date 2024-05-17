import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private static final String SERVER_ADDRESS = "localhost"; // Change this to your server's address
    private static final int SERVER_PORT = 1234; // Change this to your server's port

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected to server. Type 'exit' to quit.");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                if ("exit".equals(userInput)) {
                    break;
                } else {
                    System.out.println("Server response: " + in.readLine());
                }
            }

            out.close();
            in.close();
            stdIn.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}