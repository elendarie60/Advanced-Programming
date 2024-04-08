package org.game;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stone implements Serializable {
    private final int x;
    private final int y;
    private final StoneColor stoneColor;

    public Stone(int x, int y, StoneColor stoneColor) {
        this.x = x;
        this.y = y;
        this.stoneColor = stoneColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public StoneColor getStoneColor() {
        return stoneColor;}
}
enum StoneColor implements Serializable {
    RED,
    BLUE
}