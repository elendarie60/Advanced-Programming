import java.util.ArrayList;
import java.util.List;

public class SmartPlayer extends Thread {
    private final String name;
    private final Bag bag;
    private final int n;
    private List<Token> sequence;
    private int points = 0;

    public SmartPlayer(String name, Bag bag, int n) {
        this.name = name;
        this.bag = bag;
        this.n = n;
        this.sequence = new ArrayList<>();
    }

    public int getPoints() {
        return points;
    }

    public void run() {
        while (points < n) {
            Token token = chooseToken();
            if (token == null) break;
            System.out.println(name + " extracted token: " + token.getFirst() + "," + token.getSecond());
            updateSequence(token);
            points = calculatePoints();
        }
        System.out.println(name + " has finished with " + points + " points.");
    }

    private Token chooseToken() {
        return bag.extractToken();
    }

    private void updateSequence(Token token) {
        sequence.add(token);
        if (sequence.size() == n) {
            System.out.println(name + " formed a sequence of length " + n + ": " + sequence);
            sequence.clear();
        }
    }

    private int calculatePoints() {
        return sequence.size();
    }
}