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
    //a.setMap(y, x, this);
  } 
  public Person(int a, int c, int d, Map f, String name, int def, int atk){
    health = a;
    
    y = c;
    x = d;
    
    attack = atk;
    defense = def;
    
    this.name = name;
    //f.setMap(y, x, this);
  }
  public int getHealth(){
    return this.health;
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
	  return this.attack;
  }
  public int getDef() {
	  return this.defense;
  }


  public void setHealth(int health) {
      this.health = health;
  }


  public void setAtk(int newAtk) {
	    this.attack = newAtk;
	}
  public void setDef(int newDef) {
	    this.defense = newDef;
	}
  

}  

  
  




  
  
