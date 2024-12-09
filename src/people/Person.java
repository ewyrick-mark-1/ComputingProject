package people;

import java.lang.Math;
//import java.util.Map;


import mapPackage.*;

public class Person{
  int x;//musnt be private so player can change coords
  int y;
  private String name;
  private int health;
  public Person(Map a){
    health = 50;
   
    x = 0;
    y = 0;
    name = "default name";
    a.setMap(y, x, this);
  } 
  public Person(int a, int c, int d, Map f, String name){
    health = a;
    
    y = c;
    x = d;
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
}