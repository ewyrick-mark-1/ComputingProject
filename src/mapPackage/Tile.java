package mapPackage;

import people.*;
import backpackPackage.*;

public class Tile {
    private String terrain; // Type of terrain (grass or stone)
    private int x; // X-coordinate of the tile
    private int y; // Y-coordinate of the tile
    private Person isPlayer = null; // The player on this tile (if any)
    private Enemy enemy = null; // The enemy on this tile (if any)
    private Item stuff; // The item on this tile (if any)

    // Constructor to initialize the tile
    public Tile(int t, int b, int a, Person c, Enemy d, Item s) {
        x = a; // Set x-coordinate
        y = b; // Set y-coordinate
        stuff = s; // Set item

        // Set terrain based on the type (1 = grass, 2 = stone)
        if (t == 1) {
            terrain = "grass";
        } else if (t == 2) {
            terrain = "stone";
        } else {
            terrain = "invalid terrain";
        }

        // Assign player and enemy if provided
        if (c != null) {
            isPlayer = c;
        }
        if (d != null) {
            enemy = d;
        }
    }

    // Getters for terrain, item, coordinates, player, and enemy
    public String getTerrain() {
        return terrain;
    }

    public Item getStuff() {
        return stuff;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Person getPlayer() {
        return isPlayer;
    }

    // Setters for player, enemy, and item
    public void setPlayer(Person g) {
        isPlayer = g;
    }

    public void setPlayerFirst(Person g) {
        isPlayer = g;
        enemy = null; // No enemy if the player is set first
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setStuff(Item v) {
        stuff = v;
    }
}
