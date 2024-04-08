package org.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Serializable {
    private String name;
    private StoneColor stoneColor;

    public Player(String name, StoneColor stoneColor) {
        this.name = name;
        this.stoneColor = stoneColor;
    }

    public String getName() {
        return name;
    }

    public StoneColor getStoneColor() {
        return stoneColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStoneColor(StoneColor stoneColor) {
        this.stoneColor = stoneColor;
    }
}