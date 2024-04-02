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
        // Generate random sticks and place them on the board
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (random.nextBoolean()) {
                    sticks.add(new Stick(i, j, i, j + 1));
                }
            }
        }
    }
}
