package people;

import backpackPackage.*;
import mapPackage.*;
public class Player extends Person{
  
  Backpack u;

  public Player(Map a){
    super(a);
    u = new Backpack(4, 6);//(y, x)
    
  }
  
  public Player(int a, int c, int d, Map f, String p){
    super(a, c, d, f, p);
    u = new Backpack(4, 6);
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
    }
}

public void moveDown(Map f) {
    if (y != f.getMap().length - 1) {
        f.getMap()[y][x].setPlayer(null);
        y++;
        f.getMap()[y][x].setPlayer(this);
    }
}

public void moveLeft(Map f) {
    if (x != 0) {
        f.getMap()[y][x].setPlayer(null);
        x--;
        f.getMap()[y][x].setPlayer(this);
    }
}

public void moveRight(Map f) {
    if (x != f.getMap()[0].length - 1) {
        f.getMap()[y][x].setPlayer(null);
        x++;
        f.getMap()[y][x].setPlayer(this);
    }
}
public Item[] getInventory() {
	return u.getItems();
}
}
  

