package main;

import javax.swing.*;
import java.awt.*;
import people.*;
import backpackPackage.*;
import mapPackage.*;
import GUI.GuiOut;
import GUI.StartScreen;

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
        Player player = new Player(200, 4, 3, theMap, "Ronald", 100, 50, 200); // Player stats and position
        theMap.getTile(player.getPY(), player.getPX()).setPlayerFirst(player);

        // Create GUI components
        GuiOut gameGui = new GuiOut(theMap, player);

        // Start Screen Panel
        StartScreen startScreen = new StartScreen(screenName -> cardLayout.show(cardPanel, screenName));
        JPanel startScreenPanel = startScreen.getMainPanel();

        // Game Screen Panel
        JPanel gameScreenPanel = gameGui.getMainPanel();

        // Death Screen Panel
        JPanel deathScreenPanel = new JPanel();
        deathScreenPanel.setLayout(new BoxLayout(deathScreenPanel, BoxLayout.Y_AXIS));
        deathScreenPanel.setBackground(Color.BLACK);

        JLabel gameOverLabel = new JLabel("GAME OVER");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 36));
        gameOverLabel.setForeground(Color.RED);
        gameOverLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton exitDeathButton = new JButton("Exit to Desktop");
        exitDeathButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitDeathButton.setMaximumSize(new Dimension(200, 40));
        exitDeathButton.addActionListener(e -> System.exit(0));

        deathScreenPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Spacer
        deathScreenPanel.add(gameOverLabel);
        deathScreenPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        deathScreenPanel.add(exitDeathButton);

        // Add panels to CardLayout panel
        cardPanel.add(startScreenPanel, "StartScreen");
        cardPanel.add(gameScreenPanel, "GameScreen");
        cardPanel.add(deathScreenPanel, "DeathScreen");

        // Add CardLayout panel to frame
        frame.add(cardPanel);
        frame.setVisible(true);

        // Game loop to monitor player's health
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100); // Check every 100ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Check player health
                if (player.getHealth() <= 0) {
                    SwingUtilities.invokeLater(() -> cardLayout.show(cardPanel, "DeathScreen"));
                    break; // Exit loop to stop further checks
                }
            }
        }).start();
    }
}
