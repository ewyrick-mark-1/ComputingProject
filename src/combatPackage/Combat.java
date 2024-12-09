package combatPackage;

import mapPackage.*;
import people.*;



public class Combat {

<<<<<<< HEAD

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





=======
    public void initializeCombat(Player player, Enemy enemy, Map theMap) {
        System.out.println("Combat initiated between " + player.getName() + " and " + enemy.getName() + "!");
        
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            // Player attacks
            int playerDamage = Math.max(0, player.getAtk() - enemy.getDef());
            enemy.setHealth(enemy.getHealth() - playerDamage);
            System.out.println(player.getName() + " deals " + playerDamage + " damage to " + enemy.getName());
            
            if (enemy.getHealth() <= 0) {
                System.out.println(enemy.getName() + " has been defeated!");
                theMap.getTile(enemy.getPY(), enemy.getPX()).setEnemy(null); // Remove enemy from tile
                return; // End combat
            }

            // Enemy attacks
            int enemyDamage = Math.max(0, enemy.getAtk() - player.getDef());
            player.setHealth(player.getHealth() - enemyDamage);
            System.out.println(enemy.getName() + " deals " + enemyDamage + " damage to " + player.getName());

            if (player.getHealth() <= 0) {
                System.out.println(player.getName() + " has been defeated! GAME OVER.");
                endGame(); // Call the method to handle game over
                return; // End combat
            }
        }
    }

    private void endGame() {
        System.out.println("Thank you for playing. Exiting...");
        System.exit(0); // Exit the game
    }
>>>>>>> 7956b52ffa56ba7b2bbf0e3e0cd221dc524e46d6
}

