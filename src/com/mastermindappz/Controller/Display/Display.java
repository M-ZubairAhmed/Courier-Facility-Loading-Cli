package com.mastermindappz.Controller.Display;

import com.mastermindappz.Model.RackData;

import java.util.HashMap;
import java.util.Map;

public class Display {
    public void currentRack(HashMap<Integer, RackData> shelf) {
        displayTableHead();

        for (Map.Entry<Integer, RackData> shelvesSlot : shelf.entrySet()) {
            int slotNum = shelvesSlot.getKey();
            int registrationNum = shelvesSlot.getValue().getCode();
            int weight = shelvesSlot.getValue().getWeight();

            System.out.format("%-12d%-26d%-50d", slotNum, registrationNum, weight);
            System.out.print("\n");
        }
    }

    private void displayTableHead() {
        System.out.print("\n");
        System.out.format("%s%20s%16s", "Rack No.", "Registration No.", "Weight");
        System.out.print("\n");
    }

     public void invalidCommand(){
        System.out.println("Error, Check your command!!");
    }
}
