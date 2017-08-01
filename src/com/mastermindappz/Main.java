package com.mastermindappz;

import com.mastermindappz.Controller.NewShelf.NewSelf;
import com.mastermindappz.Controller.Load.Load;
import com.mastermindappz.Model.RackData;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NewSelf newSelf = new NewSelf();
        Load load = new Load();
        Scanner scan = new Scanner(System.in);
        int racks = -1;
        HashMap<Integer, RackData> shelf = new HashMap<Integer, RackData>();
        String scanned;
        String[] userInput;
        boolean programRunning = true;

        while (programRunning) {
            System.out.println("\nEnter command :");
            scanned = scan.nextLine();
            userInput = scanned.split("\\s+");
            String command = userInput[0];

            switch (command) {
                case ("create_shelf"): {

                    int userInputRackSize = Integer.valueOf(userInput[1]);
                    int existingRackSize = shelf.size();

                    racks = newSelf.getVerifiedRacks(userInputRackSize, existingRackSize);

                    break;
                }
                case ("load"): {
                    int productCode = Integer.valueOf(userInput[1]);
                    int productWeight = Integer.valueOf(userInput[2]);

                    shelf = load.intoRack(productCode, productWeight, shelf, racks);

                    break;
                }
                case ("dispatch"): {
                    int removeRack = Integer.valueOf(userInput[1]);
                    shelf.remove(removeRack);
                    System.out.println("Rack No." + removeRack + " is emptied");
                    System.out.print("\n");
                    break;
                }
                case ("show_rack"): {
                    System.out.print("\n");
                    System.out.format("%s%20s%16s", "Rack No.", "Registration No.", "Weight");
                    System.out.print("\n");

                    for (Map.Entry<Integer, RackData> shelvesSlot : shelf.entrySet()) {
                        int slotNum = shelvesSlot.getKey();
                        int registrationNum = shelvesSlot.getValue().getCode();
                        int weight = shelvesSlot.getValue().getWeight();

                        System.out.format("%-12d%-26d%-50d", slotNum, registrationNum, weight);
                        System.out.print("\n");
                    }
                    break;
                }
                case ("exit"): {
                    System.out.println("exiting the app!");
                    programRunning = false;
                    break;
                }
                default: {
                    System.out.println("Error, Check your command!!");
                }
            }

        }
    }
}
