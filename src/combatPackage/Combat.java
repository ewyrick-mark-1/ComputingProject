package combatPackage;

import mapPackage.*;
import people.*;



public class Combat {



  

    public void initializeCombat(Player player, Enemy enemy, Map theMap) {
        System.out.println("Combat initiated between " + player.getName() + " and " + enemy.getName() + "!");
        
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            // Player attacks
            int playerDamage = Math.max(20, player.getAtk() - enemy.getDef());
            enemy.setHealth(enemy.getHealth() - playerDamage);
            System.out.println(player.getName() + " deals " + playerDamage + " damage to " + enemy.getName());
            
            if (enemy.getHealth() <= 0) {
                System.out.println(enemy.getName() + " has been defeated!");
                theMap.getTile(enemy.getPY(), enemy.getPX()).setEnemy(null); // Remove enemy from tile
                return; // End combat
            }

            // Enemy attacks
            int enemyDamage = Math.max(20, enemy.getAtk() - player.getDef());
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

}

