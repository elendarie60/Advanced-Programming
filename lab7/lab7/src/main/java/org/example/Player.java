package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Player extends Thread {
    private String name;
    private Game game;
    private int points;

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
        this.points = 0;
    }

    public void run() {
        while (!game.isGameOver()) {
            Token token = game.extractTokenFromBag();
            if (token != null) {
                System.out.println(name + " extracted token: " + token);
                points = Math.max(points, evaluateSequence(token));
            }
        }
        System.out.println(name + " received " + points + " points.");
    }

    private int evaluateSequence(Token token) {
        List<Token> sequence = new ArrayList<>();
        sequence.add(token);
        int maxPoints = 1;
        while (true) {
            List<Token> nextTokens = game.findNextTokens(sequence.get(sequence.size() - 1));
            Token nextToken = null;
            for (Token t : nextTokens) {
                if (!sequence.contains(t)) {
                    nextToken = t;
                    break;
                }
            }
            if (nextToken != null) {
                sequence.add(nextToken);
                maxPoints = Math.max(maxPoints, sequence.size());
            } else {
                break;
            }
        }
        return maxPoints;
    }
}
