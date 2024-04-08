package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Token {
    private int num1;
    private int num2;

    public Token(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public String toString() {
        return "(" + num1 + ", " + num2 + ")";
    }
}
