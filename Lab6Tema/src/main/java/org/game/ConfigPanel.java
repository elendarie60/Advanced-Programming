package org.game;
import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JSpinner rowSpinner;
    JSpinner colSpinner;
    JButton newGameButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        // Create the label and the spinner for grid size
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        // Create spinners for rows and columns
        rowSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        colSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        // Create a button for starting a new game
        newGameButton = new JButton("New Game");

        // Add components to the panel
        setLayout(new FlowLayout());
        add(label);
        add(spinner);
        add(new JLabel("Rows:"));
        add(rowSpinner);
        add(new JLabel("Columns:"));
        add(colSpinner);
        add(newGameButton);
    }
}
