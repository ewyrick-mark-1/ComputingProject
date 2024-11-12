package main;

import java.util.Scanner;
import people.*;
import backpackPackage.*;
import mapPackage.*;
class Main {
  private static Map theMap;
  private static Player a;
  private static Player b;
  public static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
    
    theMap = new Map(1, 5, 5); //first # is terrain type, #2 is x, #3 is y
    
    a = new Player(1, 2, 4, 3, theMap, "john"); // a & b are health & money last two are y & x cords
    b = new Player(theMap);
    
    getStrung();
      while(true){
        p("\noptions:");
        p("up : move up");
        p("down : move down");
        p("right : move right");
        p("left : move left");
        if(theMap.getMap()[a.getPY()][a.getPX()].getStuff() != null){
          p("harvest "+theMap.getMap()[a.getPY()][a.getPX()].getStuff().getName()+": take");
        }
        String response = scan.nextLine();
        if(response.equals("up")){
          a.moveUp(theMap);
          getStrung();
        }else if(response.equals("down")){
          a.moveDown(theMap);
          getStrung();
        }else if(response.equals("right")){
          a.moveRight(theMap);
          getStrung();
        }else if(response.equals("left")){
          a.moveLeft(theMap);
          getStrung();
        }else if(response.equals("add")){
          a.addInv(new Item("apple", 2));
          getStrung();
        }else if(response.equals("take") && theMap.getMap()[a.getPY()][a.getPX()] != null){
          a.addInv(theMap.getMap()[a.getPY()][a.getPX()].getStuff());
          theMap.getMap()[a.getPY()][a.getPX()].setStuff(null);
          getStrung();
        }else{
          p("invaild, try again.");
        }
      }
  }

  public static void getStrung() {
    p("map = \n" + theMap.outputMap());
    p("money a = " + a.getMoney());
    p("money b = " + b.getMoney());
    p("health a = " + a.getHealth());
    p("health b = " + b.getHealth());
    p("\nbackpack a = " + a.InvString());
    p("backpack b = " + b.InvString());
    p("location a = ("+a.getPY()+", "+a.getPX()+")");
    p("location b = ("+b.getPY()+", "+b.getPX()+")");
  }
  
  public static void p(Object g) {
    System.out.println(g);
  }
}

 
  

