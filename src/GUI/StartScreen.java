package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Top Down - Start Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);
        
        // Create the title label
        JLabel titleLabel = new JLabel("Top Down");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create the buttons
        JButton startButton = new JButton("Start");
        JButton settingsButton = new JButton("Game Settings");
        JButton exitButton = new JButton("Exit");

        // Set button alignment and margins
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.setMaximumSize(new Dimension(200, 40));
        settingsButton.setMaximumSize(new Dimension(200, 40));
        exitButton.setMaximumSize(new Dimension(200, 40));

        // Add action listeners for the buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Starting the game...");
                // Add code here to transition to the game screen
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opening settings...");
                // Add code here to open the game settings menu
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Add components to the panel
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Spacer
        panel.add(startButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        panel.add(settingsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        panel.add(exitButton);

        // Add panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
