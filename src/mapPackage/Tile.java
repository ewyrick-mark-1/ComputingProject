package mapPackage;

import people.*;
import backpackPackage.*;

public class Tile{
  private String terrain;
  private int x;
  private int y;
  private Person isPlayer = null;
  private int enemyType;
  private Item stuff;
  public Tile(int t, int a, int b, Person c, int d, Item s){
    x = a;
    y = b;
    enemyType = d;
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
  public int getMonster(){
    return enemyType;
  }
  public Person getPlayer(){
    return isPlayer;
  }
  public void setPlayer(Person g){
    isPlayer = g;
    enemyType = -1;
  }
  public void setMonster(int z){
    enemyType = z;
  }
  public void setStuff(Item v){
    stuff = v;
  }
  
}