package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Game {
    private Bag bag;
    private List<Player> players;
    private boolean gameOver;

    public Game(int n, int numPlayers) {
        bag = new Bag(n);
        players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player " + i, this));
        }
        gameOver = false;
    }

    public synchronized Token extractTokenFromBag() {
        if (!gameOver && !bag.isEmpty()) {
            return bag.extractToken();
        }
        return null;
    }

    public synchronized List<Token> findNextTokens(Token token) {
        return bag.findNextTokens(token);
    }

    public synchronized boolean isGameOver() {
        return gameOver;
    }

    public synchronized void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void startGame() {
        for (Player player : players) {
            player.start();
        }
        while (!bag.isEmpty()) {
            try {
                Thread.sleep(100); // Sleep for 0.1 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setGameOver(true);
    }
}
