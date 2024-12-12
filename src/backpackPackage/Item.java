package backpackPackage;

public class Item{
  private String name;
  private int value;
  private int regen;
  private int indentifier;

  public Item(){
    name = "default";
    value = 0;
    regen = 0;
    indentifier = 0;
  }
  public Item(int a){
    if(a == 1){
      name = "blueberies";
      value = 5;
      
    }else if(a == 2){
      name = "stones";
      value = 4;
    }else if(a == 3){
      name = "twigs";
      value = 3;
    }else if(a == 4){
        name = "Basic Health potion";
        value = 20;
        regen = 50;
     }else if(a == 5){
          name = "Strong Health potion";
          value = 20;
          regen = 100;
     }
    indentifier = a;
  }
  public Item(String a, int b){
    name = a;
    value = b;
  }
  public String getName(){
		  return name;
  }
  public int getValue(){
    return value;
  }
  public int getRegen(){
	  return regen;
  }
  public int getIdentifier() {  
	  
	  return indentifier;
	  }
  
  }


