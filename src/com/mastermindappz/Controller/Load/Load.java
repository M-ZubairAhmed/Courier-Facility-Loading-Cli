package com.mastermindappz.Controller.Load;

import com.mastermindappz.Model.RackData;

import java.util.HashMap;

public class Load {
    private Loading loading = new Loading();

    public HashMap<Integer, RackData> intoRack(int productCode, int productWeight, HashMap<Integer, RackData> shelf, int racks) {

        if (loading.doesShelfExists(racks)) {
            if (loading.isShelfFull(shelf.size(), racks)) {
                System.out.println("Sorry,rack is full");
                return shelf;
            } else {
                int nearestFreeRack = loading.getNearestFreeRack(shelf, racks);
                shelf.put(nearestFreeRack, new RackData(productCode, productWeight));
                System.out.println("stored at rack No." + nearestFreeRack);
                return shelf;
            }
        } else {
            System.out.println("No shelf exists");
            return shelf;
        }
    }

    public HashMap<Integer, RackData> outRack(HashMap<Integer, RackData> shelf, int rackNo) {
        shelf.remove(rackNo);
        System.out.println("Rack No." + rackNo + " is emptied");
        System.out.print("\n");
        return shelf;
    }


}
