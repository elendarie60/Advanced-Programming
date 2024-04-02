package org.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Stick implements Serializable {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public Stick(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    // Getters
}
