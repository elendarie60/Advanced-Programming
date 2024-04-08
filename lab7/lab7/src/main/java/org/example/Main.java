package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int n = 4; // Number of tokens
        int numPlayers = 3; // Number of players
        Game game = new Game(n, numPlayers);
        game.startGame();
    }
}