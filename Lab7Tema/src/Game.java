import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        int n = 5; // Number of tokens
        int numPlayers = 3;
        int timeLimit = 30000; // 30 seconds

        Bag bag = new Bag(n);
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + (i + 1), bag, n));
        }

        TimeKeeper timeKeeper = new TimeKeeper(timeLimit);
        timeKeeper.start();

        for (Player player : players) {
            player.start();
        }

        try {
            for (Player player : players) {
                player.join();
            }
            timeKeeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getPoints() > winner.getPoints()) {
                winner = player;
            }
        }

        System.out.println("The winner is: " + winner.getName() + " with " + winner.getPoints() + " points.");
    }
}
