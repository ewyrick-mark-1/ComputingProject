package backpackPackage;

public class Backpack {
    private Item[] sack;
    private int rows;
    private int cols;

    public Backpack(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        sack = new Item[rows * cols];
    }

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

    public void addItem(Item g) {
        for (int i = 0; i < sack.length; i++) {
            if (sack[i] == null) {
                sack[i] = g;
                return;
            }
        }
    }
    
    public boolean basicPotionCheck() {
        for (int i = 0; i < sack.length && sack[i] != null; i++) {
            if (sack[i].getIdentifier() == 4) {
                return true;
            }
        }
        return false;
    }
    
    public boolean strongPotionCheck() {
        for (int i = 0; i < sack.length && sack[i] != null; i++) {
            if (sack[i].getIdentifier() == 5) {
                return true;
            }
        }
        return false;
    }



    public Item[] getItems() {
        return sack;
    }
    
    public Item basicPotionGrabber() { 
    	for (int i = 0; i < sack.length && sack[i] != null; i++) {
            if (sack[i].getIdentifier() == 4 ) {
                return sack[i];
            }
        }
    	return null;

    }
    public Item strongPotionGrabber() { 
    	for (int i = 0; i < sack.length && sack[i] != null; i++) {
            if (sack[i].getIdentifier() == 5 ) {
                return sack[i];
            }
        }
    	return null;

    }


    
    public void deleteItem(Item goner) {
    	for (int i = 0; i < sack.length; i++) {
            if (sack[i].equals(goner)) {
                sack[i] = null;
                return;
            }
        }

    }
}
