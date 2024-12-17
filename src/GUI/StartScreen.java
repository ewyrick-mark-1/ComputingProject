package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class StartScreen {
    private JPanel mainPanel; // The main panel containing all components

    public StartScreen(Consumer<String> screenSwitcher) {
        // Create main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.DARK_GRAY);

        // Title label
        JLabel titleLabel = new JLabel("Top Down");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Buttons
        JButton startButton = createButton("Start", e -> screenSwitcher.accept("GameScreen"));
        JButton exitButton = createButton("Exit", e -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // Add components 
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        mainPanel.add(startButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(exitButton);
    }

    // Helper method to create buttons
    private JButton createButton(String text, java.awt.event.ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 40));
        button.addActionListener(actionListener);
        return button;
    }

    // Getter to expose the main panel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
