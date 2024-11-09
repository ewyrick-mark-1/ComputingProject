package mapPackage;

//import javax.swing.*;
import people.*;
import backpackPackage.*;
import mapPackage.*;
//import java.awt.*;

public class Map { // removed "extends JFrame"
    private Tile[][] mapA;
  
    public Map(int t, int a, int b){
        mapA = new Tile[b][a];
        int ogT = t;
        for(int y = 0; y < mapA.length; y++){
            for(int x = 0; x < mapA[0].length; x++){
                if(Math.random() < 0.2){
                    t = 2; // random chance to be stone terrain
                }
                mapA[y][x] = new Tile(t, x, y, null, ((int) (Math.random() * 4)) - 1, new Item(((int) (Math.random() * 2)) + 1));
                t = ogT;
            }
        }
        // buildMap();
    }

    /*//THIS STUFF IS FOR JFRAME - A JAVA GUI THING. BUT IT DIDNT WORK SO ITS BEEN COMMENTED OUT
    public void buildMap(){
        setTitle("Game Map");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on screen
        setVisible(true); // Make sure this is called at the right point
        // setSize(mapA.length * 100, mapA[0].length * 100);
        addPanel();
    }
    
    private void addPanel(){
        int x = mapA.length;
        int y = mapA[0].length;
        JPanel mapPanel = new JPanel(new GridLayout(x, y));
        for(Tile[] a : mapA){
            for(Tile c : a){
                JPanel tile = new JPanel();
                tile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                tile.setBackground(Color.white);
                if(c.getTerrain().equals("grass")){
                    tile.setBackground(Color.green);
                } else if(c.getTerrain().equals("stone")){
                    tile.setBackground(Color.gray);
                }
                mapPanel.add(tile);
            }
        }
        mapPanel.setPreferredSize(new Dimension(x * y, y * x));
        add(mapPanel);
        pack();
    }
    */

    public String getStrungMap(){
        String total = "\n";
        for(Tile[] a : mapA){
            for(Tile b : a){
                total += "[ " + b.getTerrain() + " " + b.getY() + " " + b.getX() + " " + PersonNameOrNull(b.getPlayer()) + " " + ItemNameOrNull(b.getStuff()) + " " + b.getMonster() + " ]";
            }
            total += "\n";
        }
        // buildMap();
        return total;
    }
  
    public Tile[][] getMap(){
        return mapA;
    }
  
    public Tile getTile(int i, int j){
        return mapA[i][j];
    }
  
    public int getMapY(){
        return mapA.length;
    }
  
    public int getMapX(){
        return mapA[0].length;
    }
  
    public void setMap(int y, int x, Person g){
        mapA[y][x].setPlayer(g);
        mapA[y][x].setMonster(-1);
    }
  
    private String ItemNameOrNull(Item item) {
        return (item != null) ? item.getName() : null;
    }
  
    private String PersonNameOrNull(Person person) {
        return (person != null) ? person.getName() : null;
    }
}
