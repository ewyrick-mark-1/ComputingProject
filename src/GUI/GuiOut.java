package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mapPackage.*;
import people.*;
import backpackPackage.*;

public class GuiOut {
    private JPanel mainPanel;
    private JPanel mapPanel, inventoryPanel, movementPanel, interactPanel, statsPanel, rightPanel, mainControlPanel;
    private Map gameMap;
    private Player player;
    private JButton basicPotionButton;
    private JButton strongPotionButton;

    public GuiOut(Map map, Player player) {
        this.gameMap = map;
        this.player = player;
        createGui();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createGui() {
        mainPanel = new JPanel(new BorderLayout());
        //mainPanel.setSize();

        rightPanel = new JPanel(new BorderLayout());
        mainControlPanel = new JPanel(new BorderLayout());

        // Top-left: Map Panel
        mapPanel = new JPanel(new GridLayout(gameMap.getMapY(), gameMap.getMapX()));
        mainPanel.add(mapPanel, BorderLayout.CENTER);

        // Right: Inventory Panel
        inventoryPanel = new JPanel(); // Initialize before setting the layout
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
        inventoryPanel.setBorder(BorderFactory.createTitledBorder("Inventory"));
        rightPanel.add(inventoryPanel, BorderLayout.NORTH);
        
        inventoryPanel.setFont(new Font("Arial", Font.BOLD, 5));

        // Bottom-left: Stats Panel
        statsPanel = new JPanel(new GridLayout(1, 3));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Player Stats"));
        mainPanel.add(statsPanel, BorderLayout.SOUTH);

        // Bottom-right: Controls Panel
        interactPanel = new JPanel(new GridLayout(1, 3));
        interactPanel.setPreferredSize(new Dimension(300, 30));
        movementPanel = new JPanel(new GridLayout(3, 3));
        movementPanel.setPreferredSize(new Dimension(300, 275));
        
        
        mainControlPanel.setBorder(BorderFactory.createTitledBorder("Controls"));
        
        
        mainControlPanel.add(movementPanel, BorderLayout.NORTH);
        mainControlPanel.add(interactPanel, BorderLayout.SOUTH);
        rightPanel.add(mainControlPanel, BorderLayout.SOUTH);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        addControlButtons();
        updatePanels();
    }

    private void addControlButtons() {
        JButton upButton = new JButton("˄");
        JButton downButton = new JButton("˅");
        JButton leftButton = new JButton("˂");
        JButton rightButton = new JButton("˃");
        JButton pickUp = new JButton("Pick up");
        basicPotionButton = new JButton("Basic potion");
        strongPotionButton = new JButton("Strong potion");
        
        upButton.setFont(new Font("Arial", Font.PLAIN, 25));
        downButton.setFont(new Font("Arial", Font.PLAIN, 25));
        leftButton.setFont(new Font("Arial", Font.PLAIN, 25));
        rightButton.setFont(new Font("Arial", Font.PLAIN, 25));
        
        pickUp.setFont(new Font("Arial", Font.PLAIN, 10));
        basicPotionButton.setFont(new Font("Arial", Font.PLAIN, 10));
        strongPotionButton.setFont(new Font("Arial", Font.PLAIN, 10));
        
        basicPotionButton.setEnabled(false);
        strongPotionButton.setEnabled(false);
        

        //movement panel
        movementPanel.add(new JLabel());
        movementPanel.add(upButton);
        movementPanel.add(new JLabel());
        movementPanel.add(leftButton);
        movementPanel.add(new JLabel());
        movementPanel.add(rightButton);
        movementPanel.add(new JLabel());
        movementPanel.add(downButton);
        movementPanel.add(new JLabel());
        
        //interact panel
        interactPanel.add(pickUp);
        interactPanel.add(basicPotionButton);
        interactPanel.add(strongPotionButton);



        upButton.addActionListener(e -> movePlayer("up"));
        downButton.addActionListener(e -> movePlayer("down"));
        leftButton.addActionListener(e -> movePlayer("left"));
        rightButton.addActionListener(e -> movePlayer("right"));
        pickUp.addActionListener(e -> pickUp());
        basicPotionButton.addActionListener(e -> useBasicPotion());
        strongPotionButton.addActionListener(e -> useStrongPotion());

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
        updatePotionButton();
        
    }
    
    public void useBasicPotion() {
    	player.usePotion(player.getBackpack().basicPotionGrabber());
    	updatePanels();
    }
    public void useStrongPotion() {
    	player.usePotion(player.getBackpack().strongPotionGrabber());
    	updatePanels();
    }

    
    private void updatePotionButton() {
    	if(player.getBackpack().basicPotionCheck() == false) {
    		basicPotionButton.setEnabled(false);
    	}else {
    		basicPotionButton.setEnabled(true);

    	}
    	
    	if(player.getBackpack().strongPotionCheck() == false) {
    		strongPotionButton.setEnabled(false);
    	}else {
    		strongPotionButton.setEnabled(true);

    	}

    }

    private void updateMapPanel() {
        mapPanel.removeAll();
        Tile[][] tiles = gameMap.getMap();
        
        // Load player icon
        ImageIcon playerIcon = new ImageIcon(getClass().getResource("/resources/emoji angry.jpg"));
        Image scaledPlayerIcon = playerIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedPlayerIcon = new ImageIcon(scaledPlayerIcon);

        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                JPanel tilePanel = new JPanel();
                tilePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Set tile color based on terrain
                tilePanel.setBackground("grass".equals(tile.getTerrain()) ? Color.GREEN : Color.GRAY);

                // Add icon if present
                JLabel icon = new JLabel();
                if (tile.getPlayer() != null) {
                    icon = new JLabel(resizedPlayerIcon); // Use player image
                } else if (tile.getEnemy() != null) {
                    if ("zombie".equals(tile.getEnemy().getName())) {
                        icon = new JLabel("Z");
                    } else if ("skellyton".equals(tile.getEnemy().getName())) {
                        icon = new JLabel("S");
                    }
                }
                tilePanel.add(icon);

                mapPanel.add(tilePanel);
            }
        }
        mapPanel.revalidate();
        mapPanel.repaint();
    }


    private void updateInventoryPanel() {
        inventoryPanel.removeAll();
        for (Item item : player.getInventory()) {
            if (item != null) {
                JLabel itemLabel = new JLabel(item.getName());
                inventoryPanel.add(itemLabel);
            }
        }
        inventoryPanel.revalidate();
        inventoryPanel.repaint();
    }

    private void updateStatsPanel() {
        statsPanel.removeAll();
        JLabel healthLabel = new JLabel("Health: " + player.getHealth());
        JLabel atkLabel = new JLabel("Attack: " + player.getAtk());
        JLabel defLabel = new JLabel("Defense: " + player.getDef());
        JLabel locationLabel = new JLabel("Location: (" + player.getPY() + ", " + player.getPX() + ")");

        statsPanel.add(healthLabel);
        statsPanel.add(atkLabel);
        statsPanel.add(defLabel);
        statsPanel.add(locationLabel);

        statsPanel.revalidate();
        statsPanel.repaint();
    }
    
        private void pickUp() {
    	player.pickUpItem(gameMap);
    	inventoryPanel.revalidate();
        inventoryPanel.repaint();
        updatePanels();


    }
    

}
