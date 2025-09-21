package com.rpglab.game.game;

import com.rpglab.game.utils.GameDisplay;
import com.rpglab.game.utils.InputManager;

/**
 * Handles the display and management of game menus and user interface elements.
 * This class provides a centralized system for creating consistent, formatted
 * menus throughout the Dungeon Adventure RPG game.
 * 
 * <p>The Menu class creates visually appealing text-based interfaces with
 * colored headers, numbered options, and input validation. It integrates
 * with the GameDisplay utility for ANSI color formatting and InputManager
 * for robust user input handling.</p>
 * 
 * <p>Key features include:</p>
 * <ul>
 *   <li>Standardized menu formatting with colored headers</li>
 *   <li>Automatic option numbering and validation</li>
 *   <li>Integration with input validation systems</li>
 *   <li>Resource cleanup for input streams</li>
 * </ul>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 * @see GameDisplay
 * @see InputManager
 */
public class Menu {

    /**
     * Constructs a new Menu instance.
     * This constructor initializes a menu system ready to display
     * formatted interfaces and handle user interactions.
     */
    public Menu() {
    }

    /**
     * Displays a formatted menu with the specified title and options.
     * This method creates a visually appealing menu interface with colored
     * headers, numbered options, and automatic input validation.
     * 
     * <p>The menu format includes:</p>
     * <ul>
     *   <li>Colored and bold title header</li>
     *   <li>Numbered options starting from 1</li>
     *   <li>Decorative borders for visual appeal</li>
     *   <li>Input validation within the valid range</li>
     * </ul>
     * 
     * @param title   the title to display at the top of the menu
     * @param options an array of menu option strings to display
     * @return the user's selected option number (1-based indexing)
     */
    public int displayMenu(String title, String[] options) {
        System.out.println();
        System.out.println("====================  " + GameDisplay.BOLD + GameDisplay.YELLOW + title + GameDisplay.RESET + "  ====================");
        
        for (int i = 0; i < options.length; i++) {
            System.out.println("[" + (i + 1) + "]: " + options[i]);
        }
        
        System.out.println("==================================================================================");
        return InputManager.readWholeNumber("Input your choice", 1, options.length);
    }

    /**
     * Displays the main game menu with core game options.
     * This method presents the primary interface that players see when
     * starting the game, offering fundamental choices like starting a new
     * adventure or exiting the application.
     * 
     * <p>The main menu includes options for:</p>
     * <ul>
     *   <li>Starting a new dungeon adventure</li>
     *   <li>Exiting the game application</li>
     * </ul>
     * 
     * @return the user's selected menu option (1 for new game, 2 for exit)
     */
    public int displayMainMenu() {
        String[] mainOptions = {"Start New Game", "Exit the game"};
        return displayMenu("DUNGEON ADVENTURE", mainOptions);
    }

    /**
     * Properly closes the menu system and releases resources.
     * This method ensures that input streams and other resources
     * used by the menu system are properly cleaned up when the
     * game session ends.
     * 
     * <p>This method should be called before terminating the application
     * to prevent resource leaks and ensure clean shutdown.</p>
     */
    public void close() {
        InputManager.close();
    }
}
