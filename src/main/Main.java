package main;

import java.util.Scanner;
import javax.swing.*;
import people.*;
import backpackPackage.*;
import mapPackage.*;
import GUI.GuiOut;


class Main {
  private static Map theMap;
  private static Player player;
  //private static Player b;
  public static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
    //test
    theMap = new Map(1, 5, 5); //first # is terrain type, #2 is x, #3 is y
    
    player = new Player(1, 4, 3, theMap, "john"); // a is health & money last two are y & x cords
   // b = new Player(theMap);
    //test
    GuiOut gui = new GuiOut(theMap, player);

    
      while(true){
    	  gui.refresh();

    	  //Nick
        p("\noptions:");
        p("up : move up");
        p("down : move down");
        p("right : move right");
        p("left : move left");
        if(theMap.getMap()[player.getPY()][player.getPX()].getStuff() != null){
          p("harvest "+theMap.getMap()[player.getPY()][player.getPX()].getStuff().getName()+": take");
        }
        String response = scan.nextLine();
        if(response.equals("up")){
        	player.moveUp(theMap);
          getStrung();
        }else if(response.equals("down")){
        	player.moveDown(theMap);
          getStrung();
        }else if(response.equals("right")){
        	player.moveRight(theMap);
          getStrung();
        }else if(response.equals("left")){
        	player.moveLeft(theMap);
          getStrung();
        }else if(response.equals("add")){
        	player.addInv(new Item("apple", 2));
          getStrung();
        }else if(response.equals("take") && theMap.getMap()[player.getPY()][player.getPX()] != null){
        	player.addInv(theMap.getMap()[player.getPY()][player.getPX()].getStuff());
          theMap.getMap()[player.getPY()][player.getPX()].setStuff(null);
          getStrung();
        }else{
          p("invaild, try again.");
        }
      }
  }

  public static void getStrung() {
    p("map = \n" + theMap.outputMap());
   
    p("health a = " + player.getHealth());
    //p("health b = " + b.getHealth());
    p("\nbackpack a = " + player.InvString());
    //p("backpack b = " + b.InvString());
    p("location a = ("+player.getPY()+", "+player.getPX()+")");
    //p("location b = ("+b.getPY()+", "+b.getPX()+")");
  }
  
  public static void p(Object g) {
    System.out.println(g);
  }
}

 
  

