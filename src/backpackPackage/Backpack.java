package backpackPackage;

public class Backpack {
    private Item[] sack; // Array to store items in the backpack
    private int rows;     // Rows for backpack grid
    private int cols;     // Columns for backpack grid 

    // Constructor: Initializes backpack with a given size
    public Backpack(int length) {
        sack = new Item[length];
    }

    // Returns a string representation of all items in the backpack
    public String SackString() {
        StringBuilder total = new StringBuilder("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j; // Map 2D indices to 1D
                if (sack[index] == null) {
                    total.append("[ - ] ");
                } else {
                    total.append("[ ").append(sack[index].getName()).append(" ").append(sack[index].getValue()).append(" ] ");
                }
            }
            total.append("\n");
        }
        return total.toString();
    }

    // Adds a new item to the backpack
    public void addItem(Item g) {
        for (int i = 0; i < sack.length; i++) {
            if (sack[i] == null) {
                sack[i] = g;
                return;
            }
        }
    }
    
    // Checks if a basic potion is in the backpack
    public boolean basicPotionCheck() {
        for (int i = 0; i < sack.length && sack[i] != null; i++) {
            if (sack[i].getIdentifier() == 4) {
                return true;
            }
        }
        return false;
    }
    
    // Checks if a strong potion is in the backpack
    public boolean strongPotionCheck() {
        for (int i = 0; i < sack.length && sack[i] != null; i++) {
            if (sack[i].getIdentifier() == 5) {
                return true;
            }
        }
        return false;
    }

    // Returns the array of items in the backpack
    public Item[] getItems() {
        return sack;
    }
    
    // Retrieves the first basic potion in the backpack
    public Item basicPotionGrabber() { 
        for (int i = 0; i < sack.length && sack[i] != null; i++) {
            if (sack[i].getIdentifier() == 4) {
                return sack[i];
            }
        }
        return null;
    }

    // Retrieves the first strong potion in the backpack
    public Item strongPotionGrabber() { 
        for (int i = 0; i < sack.length && sack[i] != null; i++) {
            if (sack[i].getIdentifier() == 5) {
                return sack[i];
            }
        }
        return null;
    }

    // Deletes a specific item from the backpack
    public void deleteItem(Item goner) {
        for (int i = 0; i < sack.length; i++) {
            if (sack[i].equals(goner)) {
                sack[i] = null;
                return;
            }
        }
    }
}
