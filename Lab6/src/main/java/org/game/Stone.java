package org.game;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Stone implements Serializable {
    private final int x;
    private final int y;
    private final Player player;

    public Stone(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    // Getters
}
