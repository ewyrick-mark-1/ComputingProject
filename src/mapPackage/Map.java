package mapPackage;

import javax.swing.*;
import people.*;
import backpackPackage.*;
import java.awt.*;
import people.*;

public class Map extends JFrame { 
    private Tile[][] mapA;
    private JPanel mapPanel;
    
    public Map(int t, int a, int b) {
        mapA = new Tile[b][a];
        int ogT = t;

        for (int y = 0; y < mapA.length; y++) {
            for (int x = 0; x < mapA[0].length; x++) {
                if (Math.random() < 0.2) {
                    t = 2; // Random chance to be stone terrain
                }

                mapA[y][x] = new Tile(t, y, x, null, null, new Item(((int) (Math.random() * 2)) + 1));

                //------------monster population-------------
                Enemy enemy = null;
                int enemyWeight = (int) (Math.random() * 100 + 1); 
                if (enemyWeight >= 90) {
                    enemy = new Enemy(100, y, x, this, "zombie", 50, 100); 
                    mapA[y][x].setEnemy(enemy);
                } else if (enemyWeight >= 80) {
                    enemy = new Enemy(50, y, x, this, "skellyton", 50, 100); 
                    mapA[y][x].setEnemy(enemy);
                }

                // Initialize the Tile with its properties
                

                // Reset terrain type to the original
                t = ogT;
            }
        }
    }

    public void buildMap(int preferredSize) {
     

        if (mapPanel == null) { // Initialize only once
            setTitle("Game Map");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Center the window on the screen

            mapPanel = new JPanel(new GridLayout(getMapY(), getMapX()));
            add(mapPanel);

            setSize(getMapX() * preferredSize, getMapY() * preferredSize);
            setVisible(true);
        }

        updateMapPanel(); // Refresh the content of the map
    }

    public void updateMapPanel() {
        mapPanel.removeAll(); // Clear existing components
        for (Tile[] row : mapA) {
            for (Tile tileData : row) {
                JPanel tile = new JPanel();
                tile.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Set tile color based on terrain
                tile.setBackground("grass".equals(tileData.getTerrain()) ? Color.green : Color.gray);

                // Add player icon if a player is present
                if (tileData.getPlayer() != null) {
                    ImageIcon pfp = new ImageIcon(getClass().getResource("/resources/emoji angry.jpg"));
                    Image pfpDisply = pfp.getImage();
                    Image ScaledPfp = pfpDisply.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel iconLabel = new JLabel(new ImageIcon(ScaledPfp));
                    tile.add(iconLabel);
                }
                mapPanel.add(tile);
            }
        }
        mapPanel.revalidate(); // Refresh the panel layout
        mapPanel.repaint();    // Redraw the panel
    }

    public String outputMap() {
        StringBuilder total = new StringBuilder("\n");
        for (Tile[] row : mapA) {
            for (Tile tile : row) {
                total.append("[ ")
                     .append(tile.getTerrain()).append(" ")
                     .append(tile.getY()).append(" ")
                     .append(tile.getX()).append(" ")
                     .append(PersonNameOrNull(tile.getPlayer())).append(" ")
                     .append(ItemNameOrNull(tile.getStuff())).append(" ")
                     .append(tile.getEnemy().getName()).append(" ]");

            }
            total.append("\n");
        }
        return total.toString();
    }

    public Tile[][] getMap() {
        return mapA;
    }

    public Tile getTile(int i, int j) {
        return mapA[i][j];
    }

    public int getMapY() {
        return mapA.length;
    }

    public int getMapX() {
        return mapA[0].length;
    }

    public void setMap(int y, int x, Person g) {
        mapA[y][x].setPlayer(g);
        mapA[y][x].setEnemy(null);
    }

    private String ItemNameOrNull(Item item) {
        return (item != null) ? item.getName() : null;
    }

    private String PersonNameOrNull(Person person) {
        return (person != null) ? person.getName() : null;
    }
}
