import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameServer {
    private ServerSocket serverSocket;
    private boolean isRunning;
    private List<ClientThread> clients;
    private Map<String, Integer> guessingGame;
    private Map<String, Game> games;

    public GameServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            isRunning = true;
            clients = new ArrayList<>();
            guessingGame = new HashMap<>();
            System.out.println("Server started on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (isRunning) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clients.add(clientThread);
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        isRunning = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void createGame(String gameId) {
        games.put(gameId, new Game());
    }

    public synchronized void joinGame(String gameId, String playerName) {
        Game game = games.get(gameId);
        if (game != null) {
            game.addPlayer(playerName);
        }
    }

    public synchronized void submitMove(String gameId, String playerName, int x, int y) {
        Game game = games.get(gameId);
        if (game != null) {
            game.submitMove(playerName, x, y);
        }
    }

    public synchronized String guessNumber(String gameId, int number) {
        if (!guessingGame.containsKey(gameId)) {
            return "No active game with id: " + gameId;
        }
        int targetNumber = guessingGame.get(gameId);
        if (number == targetNumber) {
            guessingGame.remove(gameId);
            return "Congratulations! You guessed the correct number.";
        } else if (number < targetNumber) {
            return "Too low! Try a higher number.";
        } else {
            return "Too high! Try a lower number.";
        }
    }

    public static void main(String[] args) {
        int port = 1234; // You can change the port number
        GameServer server = new GameServer(port);
        server.start();
    }
}