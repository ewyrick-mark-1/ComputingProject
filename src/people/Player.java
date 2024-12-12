package people;

import combatPackage.*;
import backpackPackage.*;
import mapPackage.*;
public class Player extends Person{
  
  Backpack u;
  Map map;
  int max_health;

  public Player(Map f){
    super(f);
    //Map map = a;
    u = new Backpack(4, 6);//(y, x)
    map = f;
    this.max_health = max_health;
    
    
  }
  
  public Player(int a, int c, int d, Map f, String p, int atk, int def, int max_health){
    super(a, c, d, f, p, atk, def);
    u = new Backpack(4, 6);
    map = f;
    this.max_health = max_health;

    f.getTile(c, d).setPlayer(this); // puts player on map after enemies are added
  }
  //--------------[backpack manipulation]---------------
  public String InvString(){
    return u.SackString();
  }

  public void addInv(Item newItem){ 
    u.addItem(newItem);
  }
  //--------------[player controller]--------------------
 public void moveUp(Map f) {
    if (y != 0) {
        f.getMap()[y][x].setPlayer(null);
        y--;
        f.getMap()[y][x].setPlayer(this);
        Enemy enemy = f.getTile(y, x).getEnemy();
        if (enemy != null) {
            Combat combat = new Combat();
            combat.initializeCombat(this, enemy, f);
        }
    }
    
    
}

public void moveDown(Map f) {
    if (y != f.getMap().length - 1) {
        f.getMap()[y][x].setPlayer(null);
        y++;
        f.getMap()[y][x].setPlayer(this);
        
        Enemy enemy = f.getTile(y, x).getEnemy();
        if (enemy != null) {
            Combat combat = new Combat();
            combat.initializeCombat(this, enemy, f);
        }
    }
}

public void moveLeft(Map f) {
    if (x != 0) {
        f.getMap()[y][x].setPlayer(null);
        x--;
        f.getMap()[y][x].setPlayer(this);
        Enemy enemy = f.getTile(y, x).getEnemy();
        if (enemy != null) {
            Combat combat = new Combat();
            combat.initializeCombat(this, enemy, f);
        }
    }
}

public void moveRight(Map f) {
    if (x != f.getMap()[0].length - 1) {
        f.getMap()[y][x].setPlayer(null);
        x++;
        f.getMap()[y][x].setPlayer(this);
        Enemy enemy = f.getTile(y, x).getEnemy();
        if (enemy != null) {
            Combat combat = new Combat();
            combat.initializeCombat(this, enemy, f);
        }
    }
}
public Item[] getInventory() {
	return u.getItems();
}

public void giveStat(Enemy enemy) {
    // Custom boost based on enemy type
    if (enemy.getName().equals("zombie")) {
        setAtk(getAtk() + 5);
        System.out.println("Gained +5 Attack from defeating a Zombie!");
    } else if (enemy.getName().equals("skellyton")) {
        setDef(getDef() + 3);
        System.out.println("Gained +3 Defense from defeating a Skellyton!");
    }
}

public void pickUpItem(Map map) {
	if(map.getMap()[this.getPY()][this.getPX()] != null){
    	this.addInv(map.getMap()[this.getPY()][this.getPX()].getStuff());
      map.getMap()[this.getPY()][this.getPX()].setStuff(null);
     
	}
}

public Backpack getBackpack() {
	return u;
}

public void usePotion(Item potion) {
    System.out.println("Current Health: " + getHealth());
    System.out.println("Potion Regen: " + potion.getRegen());

    if (getHealth() + potion.getRegen() > max_health) {
        setHealth(max_health);
    } else if (getHealth() == max_health) {
        System.out.println("Health is already at maximum.");
        return;
    } else {
        setHealth(getHealth() + potion.getRegen());
    }

    u.deleteItem(potion);
    System.out.println("Potion used. Current Health: " + getHealth());
}

}

