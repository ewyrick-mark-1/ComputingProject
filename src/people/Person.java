package people;

import java.lang.Math;
//import java.util.Map;


import mapPackage.*;

public class Person{
  int x;//musnt be private so player can change coords
  int y;
  private String name;
  
  private int health;
  int attack;
  int defense;
  
  
  public Person(Map a){
    health = 50;
   
    x = 0;
    y = 0;
    name = "default name";
    a.setMap(y, x, this);
  } 
  public Person(int a, int c, int d, Map f, String name, int def, int atk){
    health = a;
    
    y = c;
    x = d;
    
    attack = atk;
    defense = def;
    
    this.name = name;
    f.setMap(y, x, this);
  }
  public int getHealth(){
    return health;
  }
  public String getName(){
    return name;
  }
  public int getPX(){
    return x;
  }
  public int getPY(){
    return y;
  }

  public int getAtk() {
	  return attack;
  }
  public int getDef() {
	  return defense;
  }
  public void setHealth(int health) {
      this.health = health;
  }



  
  
  public void takeDamage(int damage) {
      int newHealth = getHealth() - damage;
      if (newHealth <= 0) {
          die();
      } else {
          System.out.println(getName() + " took " + damage + " damage. Remaining health: " + newHealth);
      }
      // Set the new health
      
  }

  private void die() {
      System.out.println(getName() + " has died!");
      
  }
  
  
}
  
  
  
  
  
  

