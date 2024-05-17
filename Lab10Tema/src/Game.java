import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> players;
    private Map<String, Integer> playerTimes;

    public Game() {
        players = new HashMap<>();
        playerTimes = new HashMap<>();
    }

    public void addPlayer(String playerName) {
        players.put(playerName, new Player(playerName));
        playerTimes.put(playerName, 60); // 60 seconds initial time per player (adjust as needed)
    }

    public void submitMove(String playerName, int x, int y) {
        // Implement move submission logic
    }
}