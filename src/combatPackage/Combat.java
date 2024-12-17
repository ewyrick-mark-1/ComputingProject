package combatPackage;

import mapPackage.*;
import backpackPackage.*;
import people.*;

public class Combat {

    int wave = 1; // Keeps track of the wave number

    // Initializes combat between the player and enemy
    public void initializeCombat(Player player, Enemy enemy, Map theMap) {
        System.out.println("Combat initiated between " + player.getName() + " and " + enemy.getName() + "!");
        
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            // Player attacks
            int playerDamage = Math.max(20, player.getAtk() - enemy.getDef()); // Calculate player damage
            enemy.setHealth(enemy.getHealth() - playerDamage); // Reduce enemy health
            System.out.println(player.getName() + " deals " + playerDamage + " damage to " + enemy.getName());
            
            if (enemy.getHealth() <= 0) {
                System.out.println(enemy.getName() + " has been defeated!");

                // Give player stat boost after defeating enemy
                player.giveStat(enemy);
                
                // Random chance to receive potions
                if(Math.random() > 0.6) {
                    Item healthPotion = new Item(5); // Strong Health potion
                    player.addInv(healthPotion);
                } else if(Math.random() > 0.3) {
                    Item healthPotion = new Item(4); // Basic Health potion
                    player.addInv(healthPotion);
                }

                // Remove defeated enemy from the map
                theMap.getTile(enemy.getPY(), enemy.getPX()).setEnemy(null); 
                
                // Check if all enemies are defeated and proceed to next wave
                if (theMap.enemyCheck() == false) {
                    System.out.println("Enemies defeated, next wave imminent.");
                    wave++;
                    theMap.populate(wave);
                }
                return; // End combat
            }

            // Enemy attacks
            int enemyDamage = Math.max(20, enemy.getAtk() - player.getDef()); // Calculate enemy damage
            player.setHealth(player.getHealth() - enemyDamage); // Reduce player health
            System.out.println(enemy.getName() + " deals " + enemyDamage + " damage to " + player.getName());

            if (player.getHealth() <= 0) {
                System.out.println(player.getName() + " has been defeated! GAME OVER.");
                return; // End combat
            }
        }
    }

    // Ends the game
    private void endGame() {
        System.out.println("Thank you for playing. Exiting...");
        System.exit(0); // Exit the game
    }

}
