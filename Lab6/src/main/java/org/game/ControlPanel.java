package org.game;

import javax.swing.*;

public class ControlPanel extends JPanel {
    // Define components for the control panel
    private JButton loadButton;
    private JButton saveButton;
    private JButton exitButton;

    public ControlPanel() {
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