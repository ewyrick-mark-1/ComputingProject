package people;

import mapPackage.Map;

public class Enemy extends Person {

    // Constructor to create an Enemy object
    public Enemy(int a, int c, int d, Map f, String p, int def, int atk) {
        // Call the superclass (Person) constructor with the required parameters
        super(a, c, d, f, p, def, atk); 
    }
}
