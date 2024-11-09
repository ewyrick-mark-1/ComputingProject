import java.lang.Math;
public class Person{
  int x;//musnt not be private so player can change coords
  int y;
  private String name;
  private int health;
  private int money;
  public Person(Map a){
    health = 50;
    money = ((int) (Math.random()*99))+1;
    x = 0;
    y = 0;
    name = "default name";
    a.setMap(y, x, this);
  } 
  public Person(int a, int b, int c, int d, Map f, String name){
    health = a;
    money = b;
    y = c;
    x = d;
    this.name = name;
    f.setMap(y, x, this);
  }
  public int getMoney(){
    return money;
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