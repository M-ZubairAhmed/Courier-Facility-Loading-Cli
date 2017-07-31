package com.mastermindappz.Controller.NewShelf;

public class NewSelf {
    private Shelfing shelfing = new Shelfing();

    public boolean checking(int racks, int filledRacks) {
        if (shelfing.isValidShelf(racks)) {
            if (shelfing.doesShelfExist(filledRacks)) {
                System.out.println("Shelf of size " + racks + " already exists");
                return false;
            } else {
                System.out.println("Created a shelf with " + racks + " racks");
                return true;
            }
        } else {
            System.out.println("Each level in the shelf has minimum 2 racks,\n" +
                    "therefore it has to be an even number");
            return false;
        }
    }
}
