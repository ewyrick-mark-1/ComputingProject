package backpackPackage;

public class Item {
  private String name;    // Name of the item
  private int value;      // Value of the item
  private int regen;      // Regeneration value (for potions)
  private int indentifier; // Identifier to distinguish items

  // Default constructor: Initializes item with default values
  public Item(){
    name = "default";
    value = 0;
    regen = 0;
    indentifier = 0;
  }

  // Constructor: Initializes item based on identifier (a)
  public Item(int a){
    if(a == 1){
      name = "blueberies";
      value = 5;
    } else if(a == 2){
      name = "stones";
      value = 4;
    } else if(a == 3){
      name = "twigs";
      value = 3;
    } else if(a == 4){
        name = "Basic Health potion";
        value = 20;
        regen = 50;  // Health regeneration for basic potion
    } else if(a == 5){
        name = "Strong Health potion";
        value = 20;
        regen = 100; // Health regeneration for strong potion
    }
    indentifier = a;  // Set item identifier
  }

  // Constructor: Initializes item with custom name and value
  public Item(String a, int b){
    name = a;
    value = b;
  }

  // Getter for item name
  public String getName(){
    return name;
  }

  // Getter for item value
  public int getValue(){
    return value;
  }

  // Getter for regeneration value
  public int getRegen(){
    return regen;
  }

  // Getter for item identifier
  public int getIdentifier() {  
    return indentifier;
  }
}
