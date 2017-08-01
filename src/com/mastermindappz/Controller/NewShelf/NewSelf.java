package com.mastermindappz.Controller.NewShelf;

public class NewSelf {
    private Shelfing shelfing = new Shelfing();

    public int getVerifiedRacks(int userInputRackSize, int existingRackSize) {
        if (shelfing.isValidShelf(userInputRackSize)) {
            if (shelfing.doesShelfExist(existingRackSize)) {
                System.out.println("Shelf of size " + userInputRackSize + " already exists");
                return userInputRackSize;
            } else {
                System.out.println("Created a shelf with " + userInputRackSize + " racks");
                return userInputRackSize;
            }
        } else {
            System.out.println("Each level in the shelf has minimum 2 racks,\n" +
                    "therefore it has to be an even number");
            return -1;
        }
    }
}
