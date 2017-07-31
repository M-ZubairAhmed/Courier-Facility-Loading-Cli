package com.mastermindappz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int racks = -1;
        HashMap<Integer, slotDataType> shelf = new HashMap<Integer, slotDataType>();
        String scanned;
        String[] userInput;
        boolean shouldLoop = true;

        while (shouldLoop) {
            System.out.println("\nEnter command :");
            scanned = scan.nextLine();
            userInput = scanned.split("\\s+");
            String command = userInput[0];

            switch (command) {
                case ("create_shelf"): {
                    //Checking for even condition
                    if (Integer.valueOf(userInput[1]) % 2 != 0) {
                        System.out.println("Each level in the shelf has minimum 2 racks,\n" +
                                "therefore it has to be an even number");
                    } else {
//                    if ()
                        racks = Integer.valueOf(userInput[1]);
                        System.out.println("Created a shelf with " + racks + " racks");
                    }

                    break;
                }
                case ("store"): {
                    int productCode = Integer.valueOf(userInput[1]);
                    int productWeight = Integer.valueOf(userInput[2]);
                    Integer rack = -1;
                    int leftRackRow = 1;
                    int rightRackRow = racks;

                    for (int i = 0; i <= racks; i++) {
                        if (i % 2 == 0) {
                            if (shelf.get(leftRackRow) == null) {
                                rack = leftRackRow;
                                break;
                            } else {
                                leftRackRow++;
                            }
                        } else {
                            if (shelf.get(rightRackRow) == null) {
                                rack = rightRackRow;
                                break;
                            } else {
                                rightRackRow--;
                            }
                        }
                    }

                    if (rack == -1) {
                        System.out.println("Sorry,rack is full");
                    } else {
                        shelf.put(rack, new slotDataType(productCode, productWeight));
                        System.out.println("stored at rack No." + rack);
                    }
                    break;
                }
                case ("dispatch"): {
                    int removingIndex = Integer.valueOf(userInput[1]);
                    shelf.remove(removingIndex);
                    System.out.println("Rack No." + removingIndex + " is emptied");
                    System.out.print("\n");
                    break;
                }
                case ("show_rack"): {
                    System.out.print("\n");
                    System.out.format("%s%20s%16s", "Rack No.", "Registration No.", "Weight");
                    System.out.print("\n");

                    for (Map.Entry<Integer, slotDataType> shelvesSlot : shelf.entrySet()) {
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
                    shouldLoop = false;
                    break;
                }
                default: {
                    System.out.println("Error, Check your command!!");
                }
            }

        }
    }
}
