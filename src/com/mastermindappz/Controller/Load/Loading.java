package com.mastermindappz.Controller.Load;

import com.mastermindappz.Model.RackData;

import java.util.HashMap;

class Loading {

    boolean isShelfFull(int rackMaxSize, int rackCurrentSize) {
        return rackMaxSize == rackCurrentSize;
    }

    int getNearestFreeRack(HashMap<Integer, RackData> shelf, int racks) {
        int leftRackRow = 1;
        int rightRackRow = racks;

        for (int i = 0; i <= racks; i++) {
            if (i % 2 == 0) {
                if (shelf.get(leftRackRow) == null) {
                    return leftRackRow;
                } else {
                    leftRackRow++;
                }
            } else {
                if (shelf.get(rightRackRow) == null) {
                    return rightRackRow;
                } else {
                    rightRackRow--;
                }
            }
        }
        return 0;
    }

    boolean doesShelfExists(int racks){
        return racks != -1;
    }
}
