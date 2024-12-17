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
        frame.setLocationRelativeTo(null); // Center the frame

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Initialize map and player
        Map theMap = new Map(1, 5, 5); // Map with 5x5 grid
        Player player = new Player(200, 4, 3, theMap, "Ronald", 100, 50, 200); // Player stats and position
        theMap.getTile(player.getPY(), player.getPX()).setPlayerFirst(player);

        // Initialize GUI components
        GuiOut gameGui = new GuiOut(theMap, player);

        // Start screen panel
        StartScreen startScreen = new StartScreen(screenName -> cardLayout.show(cardPanel, screenName));
        JPanel startScreenPanel = startScreen.getMainPanel();

        // Game screen panel
        JPanel gameScreenPanel = gameGui.getMainPanel();

        // Death screen panel
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

        // Add panels to CardLayout
        cardPanel.add(startScreenPanel, "StartScreen");
        cardPanel.add(gameScreenPanel, "GameScreen");
        cardPanel.add(deathScreenPanel, "DeathScreen");

        // Add CardLayout panel to frame
        frame.add(cardPanel);
        frame.setVisible(true);

        // Game loop to check player health
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100); // Check every 100ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Check player health and show death screen if health is zero
                if (player.getHealth() <= 0) {
                    SwingUtilities.invokeLater(() -> cardLayout.show(cardPanel, "DeathScreen"));
                    break; // Stop checking once health is zero
                }
            }
        }).start();
    }
}
