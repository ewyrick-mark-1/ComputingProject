package people;

import mapPackage.*;

public class Person {
    // Coordinates for the Person (Player or Enemy)
    int x; // x-coordinate, not private so it can be modified directly
    int y; // y-coordinate

    // Person's attributes
    private String name; // Name of the person (player or enemy)
    private int health; // Health of the person
    int attack; // Attack power of the person
    int defense; // Defense power of the person

    // Default constructor to initialize a Person object with default values
    public Person(Map a) {
        health = 50; // Default health value
        x = 0; // Default x-coordinate
        y = 0; // Default y-coordinate
        name = "default name"; // Default name
        // a.setMap(y, x, this); // Optionally place the person on the map (not used in this constructor)
    }

    // Constructor to initialize a Person object with specific attributes
    public Person(int a, int c, int d, Map f, String name, int def, int atk) {
        health = a; // Initialize health
        y = c; // Initialize y-coordinate
        x = d; // Initialize x-coordinate
        attack = atk; // Initialize attack power
        defense = def; // Initialize defense power
        this.name = name; // Set the name of the person
        // f.setMap(y, x, this); // Optionally place the person on the map (not used here)
    }

    // Getter methods to access the person's attributes
    public int getHealth() {
        return this.health; // Return health value
    }

    public String getName() {
        return name; // Return the name of the person
    }

    public int getPX() {
        return x; // Return x-coordinate
    }

    public int getPY() {
        return y; // Return y-coordinate
    }

    public int getAtk() {
        return this.attack; // Return attack power
    }

    public int getDef() {
        return this.defense; // Return defense power
    }

    // Setter methods to modify the person's attributes
    public void setHealth(int health) {
        this.health = health; // Set health value
    }

    public void setAtk(int newAtk) {
        this.attack = newAtk; // Set new attack power
    }

    public void setDef(int newDef) {
        this.defense = newDef; // Set new defense power
    }
}
