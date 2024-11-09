public class Item{
  private String name;
  private int value;
  public Item(){
    name = "default";
    value = 0;
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
    }
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
}