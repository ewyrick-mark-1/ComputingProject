package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mapPackage.*;
import people.*;
import backpackPackage.*;

public class GuiOut {
    private JFrame frame;
    private JPanel mapPanel, inventoryPanel, controlsPanel, statsPanel, rightPanel;
    private Map gameMap;
    private Player player;

    public GuiOut(Map map, Player player) {
        this.gameMap = map;
        this.player = player;
        createGui();
    }

    private void createGui() {
        frame = new JFrame("Game Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        rightPanel = new JPanel(new BorderLayout());
        // Top-left: Map Panel
        mapPanel = new JPanel(new GridLayout(gameMap.getMapY(), gameMap.getMapX()));
        frame.add(mapPanel, BorderLayout.CENTER);

        // Right: Inventory Panel
        inventoryPanel = new JPanel();
        inventoryPanel.setBorder(BorderFactory.createTitledBorder("Inventory"));
        //inventoryPanel.setPreferredSize(new Dimension(200, 10));
        //frame.add(inventoryPanel, BorderLayout.EAST);

        // Bottom-left: Stats Panel
        statsPanel = new JPanel(new GridLayout(1, 3));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Player Stats"));
        frame.add(statsPanel, BorderLayout.SOUTH);

        // Bottom-right: Controls Panel
        controlsPanel = new JPanel(new GridLayout(2, 3));
        controlsPanel.setBorder(BorderFactory.createTitledBorder("Controls"));
        //frame.add(controlsPanel, BorderLayout.SOUTH);
        rightPanel.add(controlsPanel, BorderLayout.SOUTH);
        rightPanel.add(inventoryPanel, BorderLayout.NORTH);
        frame.add(rightPanel, BorderLayout.EAST);
        addControlButtons();
        updatePanels();

        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private void addControlButtons() {
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");
        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");

        controlsPanel.add(new JLabel());
        controlsPanel.add(upButton, BorderLayout.NORTH);
        controlsPanel.add(new JLabel());
        controlsPanel.add(leftButton, BorderLayout.WEST);
        controlsPanel.add(new JLabel());
        controlsPanel.add(rightButton, BorderLayout.EAST);
        controlsPanel.add(new JLabel());
        controlsPanel.add(downButton, BorderLayout.SOUTH);

        upButton.addActionListener(e -> movePlayer("up"));
        downButton.addActionListener(e -> movePlayer("down"));
        leftButton.addActionListener(e -> movePlayer("left"));
        rightButton.addActionListener(e -> movePlayer("right"));
    }

    private void movePlayer(String direction) {
        switch (direction) {
            case "up":
                player.moveUp(gameMap);
                break;
            case "down":
                player.moveDown(gameMap);
                break;
            case "left":
                player.moveLeft(gameMap);
                break;
            case "right":
                player.moveRight(gameMap);
                break;
        }
        updatePanels();
    }

    public void updatePanels() {
        updateMapPanel();
        updateInventoryPanel();
        updateStatsPanel();
    }

    private void updateMapPanel() {
        mapPanel.removeAll();
        Tile[][] tiles = gameMap.getMap();
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                JPanel tilePanel = new JPanel();
                tilePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Set tile color based on terrain
                tilePanel.setBackground("grass".equals(tile.getTerrain()) ? Color.GREEN : Color.GRAY);

                // Add player icon if present
                if (tile.getPlayer() != null) {
                    JLabel playerIcon = new JLabel("P"); // Placeholder for player icon
                    tilePanel.add(playerIcon);
                }

                mapPanel.add(tilePanel);
            }
        }
        mapPanel.revalidate();
        mapPanel.repaint();
    }

    private void updateInventoryPanel() {
        inventoryPanel.removeAll();
        for (Item item : player.getInventory()) {
        	if(item != null) {
            JLabel itemLabel = new JLabel(item.getName() + " x" );
            inventoryPanel.add(itemLabel);
        	}
        }
        inventoryPanel.revalidate();
        inventoryPanel.repaint();
    }

    private void updateStatsPanel() {
        statsPanel.removeAll();
        JLabel healthLabel = new JLabel("Health: " + player.getHealth());
        JLabel locationLabel = new JLabel("Location: (" + player.getPY() + ", " + player.getPX() + ")");

        statsPanel.add(healthLabel);
        statsPanel.add(locationLabel);

        statsPanel.revalidate();
        statsPanel.repaint();
    }
    public void refresh() {
        updateMapPanel();
        updateInventoryPanel();
        updateStatsPanel();
    }

}