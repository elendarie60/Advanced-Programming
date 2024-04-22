import java.util.ArrayList;
import java.util.List;

public class Player extends Thread {
    private final String name;
    private final Bag bag;
    private int points = 0;
    private final int n;

    public Player(String name, Bag bag, int n) {
        this.name = name;
        this.bag = bag;
        this.n = n;
    }

    public int getPoints() {
        return points;
    }

    public void run() {
        while (true) {
            Token token = bag.extractToken();
            if (token == null || points == n) break;
            System.out.println(name + " extracted token: " + token.getFirst() + "," + token.getSecond());
            points++;
        }
        System.out.println(name + " has finished with " + points + " points.");
    }
}
