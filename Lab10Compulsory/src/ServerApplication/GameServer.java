package ServerApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private static final int PORT = 12345;
    private ServerSocket serverSocket;
    private List<ClientThread> clients = new ArrayList<>();

    public void start() throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Pass both clientSocket and this GameServer instance to the ClientThread constructor
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
            // Stop all client threads
            for (ClientThread clientThread : clients) {
                clientThread.interrupt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server stopped.");
    }

    public void broadcast(String message) {
        for (ClientThread client : clients) {
            client.sendMessage(message);
        }
    }
}