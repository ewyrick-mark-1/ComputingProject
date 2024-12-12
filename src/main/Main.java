package main;

import javax.swing.*;
import java.awt.*;
import people.*;
import backpackPackage.*;
import mapPackage.*;
import GUI.GuiOut;

public class Main {
    public static void main(String[] args) {
        // Create the main frame with CardLayout
        JFrame frame = new JFrame("Top Down - Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Initialize game components
        Map theMap = new Map(1, 5, 5); // Terrain type, X dimension, Y dimension
        Player player = new Player(200, 4, 3, theMap, "Loser Elliot", 100, 50, 200); // Player stats and position
        theMap.getTile(player.getPY(), player.getPX()).setPlayerFirst(player);

        // Create GUI components
        GuiOut gameGui = new GuiOut(theMap, player);

        // Start Screen Panel
        JPanel startScreenPanel = new JPanel();
        startScreenPanel.setLayout(new BoxLayout(startScreenPanel, BoxLayout.Y_AXIS));
        startScreenPanel.setBackground(Color.DARK_GRAY);

        JLabel titleLabel = new JLabel("Top Down");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.setMaximumSize(new Dimension(200, 40));
        exitButton.setMaximumSize(new Dimension(200, 40));

        startButton.addActionListener(e -> cardLayout.show(cardPanel, "GameScreen"));
        exitButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        startScreenPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        startScreenPanel.add(titleLabel);
        startScreenPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Spacer
        startScreenPanel.add(startButton);
        startScreenPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        startScreenPanel.add(exitButton);

        // Game Screen Panel
        JPanel gameScreenPanel = gameGui.getMainPanel();

        // Add panels to CardLayout panel
        cardPanel.add(startScreenPanel, "StartScreen");
        cardPanel.add(gameScreenPanel, "GameScreen");

        // Add CardLayout panel to frame
        frame.add(cardPanel);
        frame.setVisible(true);
    }
}