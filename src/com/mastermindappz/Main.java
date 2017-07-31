package com.mastermindappz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int slotSize = -1;
        HashMap<Integer, slotDataType> slotDataMap = new HashMap<Integer, slotDataType>();
        String inputFromUser;
        String[] result;
        boolean shouldLoop = true;

        while (shouldLoop) {
            System.out.println("\nEnter command :");
            inputFromUser = scan.nextLine();
            result = inputFromUser.split("\\s+");
            String command = result[0];

            if (command.equals("create_rack")) {
                slotSize = Integer.valueOf(result[1]);
                //Checking for even condition
                if (slotSize % 2 != 0) {
                    System.out.println("Each level in the rack has minimum 2 slots,\n" +
                            "therefore it has to be an even number");
                    slotSize = -1;
                } else {
                    System.out.println("Created a Rack with " + slotSize + " shelves");
                }

            } else if (command.equals("store")) {
                int incomingCode = Integer.valueOf(result[1]);
                int incomingWeight = Integer.valueOf(result[2]);
                Integer parkingIndex = -1;
                int leftRackNum = 1;
                int rightRackNum = slotSize;

                for (int i = 0; i <= slotSize; i++) {
                    if (i % 2 == 0) {
                        if (slotDataMap.get(leftRackNum) == null) {
                            parkingIndex = leftRackNum;
                            break;
                        } else {
                            leftRackNum++;
                        }
                    } else {
                        if (slotDataMap.get(rightRackNum) == null) {
                            parkingIndex = rightRackNum;
                            break;
                        } else {
                            rightRackNum--;
                        }
                    }
                }

                if (parkingIndex == -1) {
                    System.out.println("Sorry,rack is full");
                } else {
                    slotDataMap.put(parkingIndex, new slotDataType(incomingCode, incomingWeight));
                    System.out.println("Allocated to " + parkingIndex);
                }
            } else if (command.equals("dispatch")) {
                int removingIndex = Integer.valueOf(result[1]);
                slotDataMap.remove(removingIndex);
                System.out.println("Slot " + removingIndex + " is free");
                System.out.print("\n");
            } else if (command.equals("show_rack")) {
                System.out.print("\n");
                System.out.format("%s%20s%16s", "Slot No.", "Registration No.", "Weight");
                System.out.print("\n");

                for (Map.Entry<Integer, slotDataType> map : slotDataMap.entrySet()) {
                    int slotNum = map.getKey();
                    int registrationNum = map.getValue().getCode();
                    int weight = map.getValue().getWeight();

                    System.out.format("%-12d%-26d%-50d", slotNum, registrationNum, weight);
                    System.out.print("\n");
                }
            } else if (command.equals("exit")) {
                System.out.println("exiting");
                shouldLoop = false;
            } else {
                System.out.println("Error, Check your command!!");
            }

        }
    }
}
