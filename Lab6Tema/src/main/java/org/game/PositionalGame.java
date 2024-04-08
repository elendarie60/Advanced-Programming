package org.game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PositionalGame extends Application {

    private static final int DEFAULT_GRID_SIZE = 8;
    private static final int CANVAS_SIZE = 400;
    private static final Color[] PLAYER_COLORS = {Color.RED, Color.BLUE};

    private int gridSize;
    private boolean[][] grid;
    private List<Stone> stones;
    private int currentPlayer;
    private Canvas canvas;
    private GraphicsContext gc;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Positional Game");

        // Configuration panel
        Label configLabel = new Label("Grid Size:");
        javafx.scene.control.TextField gridSizeField = new javafx.scene.control.TextField();
        gridSizeField.setText(String.valueOf(DEFAULT_GRID_SIZE));
        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> {
            gridSize = Integer.parseInt(gridSizeField.getText());
            initializeGame();
            drawBoard();
        });
        HBox configPanel = new HBox(10, configLabel, gridSizeField, newGameButton);
        configPanel.setAlignment(Pos.CENTER);

        // Canvas
        canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
        gc = canvas.getGraphicsContext2D();

        // Control panel
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveGame());
        Button loadButton = new Button("Load");
        loadButton.setOnAction(e -> loadGame());
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> primaryStage.close());
        HBox controlPanel = new HBox(10, saveButton, loadButton, exitButton);
        controlPanel.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setTop(configPanel);
        root.setCenter(canvas);
        root.setBottom(controlPanel);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        initializeGame();
        drawBoard();
    }

    private void initializeGame() {
        grid = new boolean[gridSize][gridSize];
        stones = new ArrayList<>();
        currentPlayer = 0;

        // Generate random sticks
        Random random = new Random();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = random.nextBoolean();
            }
        }
    }

    private void drawBoard() {
        double cellSize = CANVAS_SIZE / (double) gridSize;

        gc.clearRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);

        // Draw grid lines
        gc.setStroke(Color.BLACK);
        for (int i = 0; i <= gridSize; i++) {
            double x = i * cellSize;
            gc.strokeLine(x, 0, x, CANVAS_SIZE);
            gc.strokeLine(0, x, CANVAS_SIZE, x);
        }

        // Draw sticks
        gc.setStroke(Color.BLACK);
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j]) {
                    gc.strokeLine(i * cellSize, j * cellSize, (i + 1) * cellSize, (j + 1) * cellSize);
                }
            }
        }

        // Draw stones
        for (Stone stone : stones) {
            gc.setFill(PLAYER_COLORS[stone.getPlayer()]);
            gc.fillOval(stone.getX() * cellSize - cellSize / 2, stone.getY() * cellSize - cellSize / 2, cellSize, cellSize);
        }
    }

    private void saveGame() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game.ser"))) {
            oos.writeObject(grid);
            oos.writeObject(stones);
            oos.writeInt(currentPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGame() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("game.ser"))) {
            grid = (boolean[][]) ois.readObject();
            stones = (List<Stone>) ois.readObject();
            currentPlayer = ois.readInt();
            drawBoard();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static class Stone implements Serializable {
        private final int x;
        private final int y;
        private final int player;

        public Stone(int x, int y, int player) {
            this.x = x;
            this.y = y;
            this.player = player;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getPlayer() {
            return player;
        }
    }
}