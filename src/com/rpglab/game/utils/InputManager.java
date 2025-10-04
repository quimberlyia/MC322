package com.rpglab.game.utils;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Utility class for handling user input in the Dungeon Adventure RPG.
 * This class provides robust input methods with validation and error handling
 * to ensure a smooth user experience when interacting with the game through
 * console input.
 * 
 * <p>The InputManager provides standardized methods for reading different types
 * of user input including numbers, strings, yes/no responses, and pause functionality.
 * All methods include appropriate error handling and user feedback for invalid input.</p>
 * 
 * <p>Uses a single shared Scanner instance to avoid closing System.in prematurely.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class InputManager {

    /**
     * Shared Scanner instance for all input operations.
     * Using a single Scanner prevents System.in from being closed prematurely.
     * Package-private (non-final) to allow test injection via reflection.
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Reads a whole number from user input within a specified range.
     * Continues prompting the user until a valid integer within the range is entered.
     * Handles empty input, non-numeric input, and out-of-range values gracefully.
     * 
     * @param message The prompt message to display to the user
     * @param min The minimum allowed value (inclusive)
     * @param max The maximum allowed value (inclusive)
     * @return A valid integer within the specified range
     * @throws RuntimeException if input is not available (system error)
     */
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

    /**
     * Reads a string from user input with the specified prompt message.
     * Automatically trims whitespace from the beginning and end of the input.
     * 
     * @param message The prompt message to display to the user
     * @return The user's input as a trimmed string
     */
    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim(); // nextLine goes until enter and trim removes spaces
    }

    /**
     * Reads a yes/no response from user input.
     * Accepts 'y' or 'n' (case-insensitive) and continues prompting until valid input.
     * Provides clear feedback for invalid responses.
     * 
     * @param message The prompt message to display to the user
     * @return true if the user entered 'y', false if the user entered 'n'
     */
    public static boolean readYesNo(String message) {
        while (true) {
            System.out.print(message + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase(); // toLowerCase to accept uppercase and lowercase
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("Invalid input. Please enter only 'y' or 'n'.");
        }
    }
    
    /**
     * Pauses execution and waits for the user to press Enter.
     * Useful for creating breaks in gameplay, allowing users to read messages
     * before continuing with the game flow.
     * 
     * @param message The message to display while waiting for user input
     */
    public static void waitForEnter(String message) {
        System.out.print(message);
        scanner.nextLine(); // pause until Enter
    }

    /**
     * Closes the Scanner resource when the game is finished.
     * Should be called before the application terminates to properly
     * release system resources. Note: Once called, no further input
     * operations will be possible.
     */
    public static void close() {
        scanner.close();
    }

    /**
     * Resets the scanner to use the current System.in.
     * Public method primarily used for testing purposes.
     * Allows tests to inject mock input streams.
     */
    public static void resetScanner() {
        scanner = new Scanner(System.in);
    }
}