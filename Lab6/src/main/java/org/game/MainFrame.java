package org.game;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    private final int BOARD_SIZE = 10; // Adjust as needed
    private int[][] board; // Define the board variable here

    public MainFrame() {
        super("My Drawing");
        init();
        initializeGame();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        // Arrange the components in the container (frame)
        setLayout(new BorderLayout());
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Pack and display the frame
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }
    }

    private void saveGameState(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(board);
            JOptionPane.showMessageDialog(this, "Game state saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving game state!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadGameState(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            board = (int[][]) inputStream.readObject();
            repaint(); // Redraw the board
            JOptionPane.showMessageDialog(this, "Game state loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading game state!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exportGameBoardImage() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        paint(g2d);
        g2d.dispose();
        try {
            ImageIO.write(image, "png", new File("game_board.png"));
            JOptionPane.showMessageDialog(this, "Game board image exported successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error exporting game board image!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initializeGame() {
        // Initialize the board
        board = new int[BOARD_SIZE][BOARD_SIZE];

        // Generate random sticks and place them on the board
        Random random = new Random();
        int numSticks = random.nextInt(BOARD_SIZE * BOARD_SIZE / 2); // Adjust as needed
        for (int i = 0; i < numSticks; i++) {
            int row = random.nextInt(BOARD_SIZE);
            int col = random.nextInt(BOARD_SIZE);
            board[row][col] = 1; // 1 represents a stick, adjust as needed
        }
        canvas.repaint(); // Redraw the board
    }

}
