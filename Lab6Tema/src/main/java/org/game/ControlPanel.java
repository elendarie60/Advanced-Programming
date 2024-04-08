package org.game;

import javax.swing.*;

public class ControlPanel extends JPanel {
    // componentele
    private JButton loadButton;
    private JButton saveButton;
    private JButton exitButton;

    private MainFrame mainFrame; // referinta

    // Constructor accepting MainFrame
    public ControlPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        // Initialize components
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        exitButton = new JButton("Exit");

        // Add components to the panel
        add(loadButton);
        add(saveButton);
        add(exitButton);
    }
}