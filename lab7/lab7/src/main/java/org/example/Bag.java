package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Bag {
    private Queue<Token> tokens;

    public Bag(int n) {
        tokens = new LinkedList<>();
        // Initialize the bag with tokens from 1 to n
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    tokens.offer(new Token(i, j));
                }
            }
        }
    }

    public synchronized Token extractToken() {
        return tokens.poll();
    }

    public boolean isEmpty() {
        return tokens.isEmpty();
    }

    public synchronized int size() {
        return tokens.size();
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.poll());
        }
        return extracted;
    }

    public synchronized List<Token> findNextTokens(Token token) {
        List<Token> nextTokens = new ArrayList<>();
        for (Token t : tokens) {
            if (t.num1 == token.num2) {
                nextTokens.add(t);
            }
        }
        return nextTokens;
    }
}
