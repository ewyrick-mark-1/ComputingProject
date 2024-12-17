package people;

import combatPackage.*;
import backpackPackage.*;
import mapPackage.*;

public class Player extends Person {
    // Instance variables for the Player
    Backpack u; // Player's backpack for storing items
    Map map;    // The map that the player is on
    int max_health; // Maximum health of the player

    // Default constructor initializing player with a map reference
    public Player(Map f) {
        super(f); // Initialize the parent Person class with the map
        u = new Backpack(10); // Create a backpack of size 10
        map = f; // Set the player's map
    }

    // Constructor to initialize player with specific attributes
    public Player(int a, int c, int d, Map f, String p, int atk, int def, int max_health) {
        super(a, c, d, f, p, atk, def); // Initialize parent class (Person) with specified attributes
        u = new Backpack(10); // Initialize backpack
        map = f; // Set the map reference
        this.max_health = max_health; // Set the player's maximum health
        f.getTile(c, d).setPlayer(this); // Place the player on the map at the specified coordinates after enemies are added
    }

    //--------------[Backpack manipulation]---------------

    // Returns the string representation of the player's inventory
    public String InvString() {
        return u.SackString(); // Call the method to get inventory in string form
    }

    // Adds a new item to the player's inventory
    public void addInv(Item newItem) { 
        u.addItem(newItem); // Add the new item to the backpack
    }

    //--------------[Player movement and combat]--------------------

    // Moves the player up on the map, checking for an enemy encounter
    public void moveUp(Map f) {
        if (y != 0) { // Prevent moving off the top of the map
            f.getMap()[y][x].setPlayer(null); // Remove the player from the current tile
            y--; // Move the player up
            f.getMap()[y][x].setPlayer(this); // Place the player on the new tile

            Enemy enemy = f.getTile(y, x).getEnemy(); // Check if there's an enemy on the new tile
            if (enemy != null) {
                Combat combat = new Combat(); // Initialize a new combat object
                combat.initializeCombat(this, enemy, f); // Start combat with the enemy
            }
        }
    }

    // Moves the player down on the map, checking for an enemy encounter
    public void moveDown(Map f) {
        if (y != f.getMap().length - 1) { // Prevent moving off the bottom of the map
            f.getMap()[y][x].setPlayer(null); // Remove the player from the current tile
            y++; // Move the player down
            f.getMap()[y][x].setPlayer(this); // Place the player on the new tile

            Enemy enemy = f.getTile(y, x).getEnemy(); // Check if there's an enemy on the new tile
            if (enemy != null) {
                Combat combat = new Combat(); // Initialize a new combat object
                combat.initializeCombat(this, enemy, f); // Start combat with the enemy
            }
        }
    }

    // Moves the player left on the map, checking for an enemy encounter
    public void moveLeft(Map f) {
        if (x != 0) { // Prevent moving off the left side of the map
            f.getMap()[y][x].setPlayer(null); // Remove the player from the current tile
            x--; // Move the player left
            f.getMap()[y][x].setPlayer(this); // Place the player on the new tile

            Enemy enemy = f.getTile(y, x).getEnemy(); // Check if there's an enemy on the new tile
            if (enemy != null) {
                Combat combat = new Combat(); // Initialize a new combat object
                combat.initializeCombat(this, enemy, f); // Start combat with the enemy
            }
        }
    }

    // Moves the player right on the map, checking for an enemy encounter
    public void moveRight(Map f) {
        if (x != f.getMap()[0].length - 1) { // Prevent moving off the right side of the map
            f.getMap()[y][x].setPlayer(null); // Remove the player from the current tile
            x++; // Move the player right
            f.getMap()[y][x].setPlayer(this); // Place the player on the new tile

            Enemy enemy = f.getTile(y, x).getEnemy(); // Check if there's an enemy on the new tile
            if (enemy != null) {
                Combat combat = new Combat(); // Initialize a new combat object
                combat.initializeCombat(this, enemy, f); // Start combat with the enemy
            }
        }
    }

    // Returns the player's inventory as an array of Items
    public Item[] getInventory() {
        return u.getItems(); // Return the items in the player's backpack
    }

    // Grants stat boosts based on the defeated enemy type
    public void giveStat(Enemy enemy) {
        // Boost stats based on enemy type
        if (enemy.getName().equals("zombie")) {
            setAtk(getAtk() + 5); // Increase attack by 5 for defeating a Zombie
            System.out.println("Gained +5 Attack from defeating a Zombie!");
        } else if (enemy.getName().equals("skellyton")) {
            setDef(getDef() + 3); // Increase defense by 3 for defeating a Skellyton
            System.out.println("Gained +3 Defense from defeating a Skellyton!");
        }
    }

    // Allows the player to pick up an item from the current tile
    public void pickUpItem(Map map) {
        // Check if the current tile has an item
        if (map.getMap()[this.getPY()][this.getPX()] != null) {
            this.addInv(map.getMap()[this.getPY()][this.getPX()].getStuff()); // Add the item to inventory
            map.getMap()[this.getPY()][this.getPX()].setStuff(null); // Remove the item from the tile
        }
    }

    // Returns the player's backpack
    public Backpack getBackpack() {
        return u; // Return the backpack
    }

    // Use a potion to restore health
    public void usePotion(Item potion) {
        System.out.println("Current Health: " + getHealth());
        System.out.println("Potion Regen: " + potion.getRegen());

        // Use the potion and restore health, ensuring health doesn't exceed maximum
        if (getHealth() + potion.getRegen() > max_health) {
            setHealth(max_health); // Set health to maximum if potion restores more than needed
        } else if (getHealth() == max_health) {
            System.out.println("Health is already at maximum.");
            return;
        } else {
            setHealth(getHealth() + potion.getRegen()); // Restore health by potion regen value
        }

        u.deleteItem(potion); // Remove the used potion from the backpack
        System.out.println("Potion used. Current Health: " + getHealth());
    }
}
