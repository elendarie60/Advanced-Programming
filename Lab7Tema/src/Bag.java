import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Token> tokens;

    public Bag(int n) {
        tokens = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                tokens.add(new Token(i, j));
            }
        }
    }

    public synchronized Token extractToken() {
        if (tokens.isEmpty()) return null;
        return tokens.remove(0);
    }
}