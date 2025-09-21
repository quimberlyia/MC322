package com.rpglab.game.utils;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputManager {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readWholeNumber(String message, int min, int max) {

        while (true) {
            System.out.print(message + " (" + min + " - " + max + ")  > ");
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Empty input. Please enter a number.");
                    continue;
                }
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println("Value out of allowed range.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value. Please enter an integer number.");
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Input not available.", e);
            }
        }    
    }

    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim(); // nextLine goes until enter and trim removes spaces
    } 

    public static boolean readYesNo(String message) {
        while (true) {
            System.out.print(message + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase(); // toLowerCase to accept uppercase and lowercase
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("Invalid input. Please enter only 'y' or 'n'.");
        }
    }
    
    public static void waitForEnter(String message) {
        System.out.print(message);
        scanner.nextLine(); // pause until Enter
    }

    public static void close() {
        scanner.close();
    }
}