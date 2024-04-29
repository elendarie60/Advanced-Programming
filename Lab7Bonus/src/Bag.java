import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Token> tokens;

    public Bag(int n) {
        tokens = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                tokens.add(new Token(i, j));
            }
        }
    }

    public synchronized Token extractToken() {
        if (!tokens.isEmpty()) {
            return tokens.remove(tokens.size() - 1);
        }
        return null;
    }

    public synchronized boolean isEmpty() {
        return tokens.isEmpty();
    }
}