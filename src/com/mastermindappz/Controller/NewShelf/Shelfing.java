package com.mastermindappz.Controller.NewShelf;

class Shelfing {
    boolean isValidShelf(int racks) {
        return racks % 2 == 0;
    }

    boolean doesShelfExist(int filledRacks) {
        return filledRacks != 0;
    }


}
