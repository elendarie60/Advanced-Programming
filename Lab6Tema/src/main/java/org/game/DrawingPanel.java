package org.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int canvasWidth = 400, canvasHeight = 400;

    BufferedImage image; //the offscreen image
    Graphics2D offscreen; //the offscreen graphics

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(
                canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    private void init() {
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        // Example: Set up mouse listeners or other event handlers
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle mouse clicks
            }
        });
    }

    private void paintGrid() {
        //same as before, only we draw in memory now
        //only using offscreen instead of the original graphics
        offscreen.setColor(Color.BLACK);
        for (int i = 0; i < canvasWidth; i += 20) {
            offscreen.drawLine(i, 0, i, canvasHeight);
        }
        for (int i = 0; i < canvasHeight; i += 20) {
            offscreen.drawLine(0, i, canvasWidth, i);
        }
    }

    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, this);
    }
}
