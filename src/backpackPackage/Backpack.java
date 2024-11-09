package backpackPackage;

public class Backpack{
  private Item[][] sack;
  public Backpack(int y, int x){
    sack = new Item[y][x];
  }
  public String SackString() {
    String total = "\n";
    for (int i = 0; i < sack.length; i++) {
        for (int j = 0; j < sack[i].length; j++) {
            if (sack[i][j] == null) {
                total += "[ - ] ";
            } else {
                total += "[ " + sack[i][j].getName() + " " + sack[i][j].getValue() + " ] ";
            }
        }
        total += "\n";
    }
    return total;
}

  public void addItem(Item g) {
    for (int i = 0; i < sack.length; i++) {
        for (int j = 0; j < sack[0].length; j++) {
            if (sack[i][j] == null) {
                sack[i][j] = g;
                return;
            }
        }
    }
}

}