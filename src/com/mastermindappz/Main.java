package com.mastermindappz;

import com.mastermindappz.Controller.Display.Display;
import com.mastermindappz.Controller.Load.Load;
import com.mastermindappz.Controller.NewShelf.NewSelf;
import com.mastermindappz.Model.RackData;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        NewSelf newSelf = new NewSelf();
        Load load = new Load();
        Display display = new Display();

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
                    int rackNo = Integer.valueOf(userInput[1]);
                    shelf = load.outRack(shelf, rackNo);

                    break;
                }
                case ("show_rack"): {
                    display.currentRack(shelf);

                    break;
                }
                case ("exit"): {
                    System.out.println("exiting the app!");
                    programRunning = false;

                    break;
                }
                default: {
                    display.invalidCommand();
                }
            }

        }
    }
}
