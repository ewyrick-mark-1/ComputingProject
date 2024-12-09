package combatPackage;

import mapPackage.*;
import people.*;



public class Combat {

	
	 public void takeDamage(Person target, int damage, Map theMap) {
		    // Calculate the new health
		    int newHealth = target.getHealth() - damage;
		    
		    // Check if the entity has died
		    if (newHealth <= 0) {
		        System.out.println(target.getName() + " took " + damage + " damage and has died!");
		        die(target, theMap); // Call the die method
		    } else {
		        // Update the health and print the remaining health
		        System.out.println(target.getName() + " took " + damage + " damage. Remaining health: " + newHealth);
		        target.setHealth(newHealth); // Ensure the health is updated
		    }
		}


	  public void die(Person target, Map theMap) {
		    theMap.getTile(target.getPY(), target.getPX()).setEnemy(null); // Mark no enemy on the tile
		    System.out.println(target.getName() + " has died!");
		}

	  
	
	
	
}
