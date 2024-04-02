package org.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Player implements Serializable {
    private final String name;
    private final StoneColor stoneColor;

    public Player(String name, StoneColor stoneColor) {
        this.name = name;
        this.stoneColor = stoneColor;
    }

    public StoneColor getStoneColor() {
        return stoneColor;

    }

    enum StoneColor {
        RED,
        BLUE
    }
}