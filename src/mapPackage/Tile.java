package mapPackage;

import people.*;
import backpackPackage.*;

public class Tile{
  private String terrain;
  private int x;
  private int y;
  private Person isPlayer = null;
  private Enemy enemy = null;
  private Item stuff;
  public Tile(int t, int b, int a, Person c, Enemy d, Item s){
    x = a;
    y = b;
    stuff = s;
    if(t == 1){
      terrain = "grass";
    }else if(t == 2){
      terrain = "stone";
    }else{
      terrain = "invalid terrain";
    }
    if(c != null){
      isPlayer = c;
    }
    if(d != null){
        enemy = d;
      }
  }
  public String getTerrain(){
    return terrain;
  }
  public Item getStuff(){
    return stuff;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public Enemy getEnemy(){
    return enemy;
  }
  public Person getPlayer(){
    return isPlayer;
  }
  public void setPlayer(Person g){
    isPlayer = g;
    //enemy = null;
  }
  public void setEnemy(Enemy z){
    enemy = z;
  }
  public void setStuff(Item v){
    stuff = v;
  }
  
}