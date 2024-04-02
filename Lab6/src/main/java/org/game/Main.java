package org.game;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame(); // Create an instance of MainFrame
            frame.setVisible(true); // Make the frame visible
        });
    }
}