package org.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board implements Serializable {
    private final int size;
    private final List<Stick> sticks;
    private Stone[][] stones;

    public Board(int size) {
        this.size = size;
        this.sticks = new ArrayList<>();
        this.stones = new Stone[size][size];
        initializeSticks();
    }

    private void initializeSticks() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (random.nextBoolean()) {
                    sticks.add(new Stick(i, j, i, j + 1));
                }
            }
        }
    }

    public void placeStone(Stone stone, int x, int y) {
        if (isValidPosition(x, y)) {
            if (stones[x][y] == null) {
                stones[x][y] = stone;
            } else {
                System.out.println("Position is already occupied!");
            }
        } else {
            System.out.println("Invalid position!");
        }
    }

    public boolean removeStone(int x, int y) {
        if (isValidPosition(x, y) && stones[x][y] != null) {
            stones[x][y] = null;
            return true;
        }
        return false;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    public void displayBoard() {
        System.out.println("Current Board State:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (stones[i][j] != null) {
                    System.out.print(stones[i][j].getStoneColor() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}