package ServerApplication;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private GameServer server;

    public ClientThread(Socket clientSocket, GameServer server) {
        this.clientSocket = clientSocket;
        this.server = server;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server received: " + inputLine);
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                } else if (inputLine.equalsIgnoreCase("stop")) {
                    server.broadcast("Server stopped");
                    break;
                } else {
                    server.broadcast("Server received the request: " + inputLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}