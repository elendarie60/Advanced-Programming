import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private GameServer server;
    private String playerName;
    private boolean isPlaying;

    public ClientThread(Socket socket, GameServer server) {
        this.clientSocket = socket;
        this.server = server;
        this.playerName = "";
        this.isPlaying = false;
    }

    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] command = inputLine.split(" ");
                switch (command[0]) {
                    case "create":
                        handleCreateGame(command);
                        break;
                    case "join":
                        handleJoinGame(command);
                        break;
                    case "submit":
                        handleSubmitMove(command);
                        break;
                    case "exit":
                        out.println("Goodbye!");
                        return;
                    default:
                        out.println("Unknown command: " + command[0]);
                }
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleCreateGame(String[] command) {
        if (command.length != 2) {
            out.println("Invalid command format. Usage: create <gameId>");
            return;
        }
        String gameId = command[1];
        server.createGame(gameId);
        out.println("Game created: " + gameId);
    }

    private void handleJoinGame(String[] command) {
        if (command.length != 3) {
            out.println("Invalid command format. Usage: join <gameId> <playerName>");
            return;
        }
        String gameId = command[1];
        String playerName = command[2];
        server.joinGame(gameId, playerName);
        this.playerName = playerName;
        this.isPlaying = true;
        out.println("Joined game: " + gameId);
    }

    private void handleSubmitMove(String[] command) {
        if (!isPlaying) {
            out.println("You are not currently in a game. Use 'join' to join a game.");
            return;
        }
        if (command.length != 4) {
            out.println("Invalid command format. Usage: submit <gameId> <x> <y>");
            return;
        }
        String gameId = command[1];
        int x, y;
        try {
            x = Integer.parseInt(command[2]);
            y = Integer.parseInt(command[3]);
        } catch (NumberFormatException e) {
            out.println("Invalid coordinates. Please provide integers for x and y.");
            return;
        }
        server.submitMove(gameId, playerName, x, y);
        out.println("Move submitted for game: " + gameId);
    }
}