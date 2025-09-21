package com.rpglab.game.game;

import com.rpglab.game.utils.GameDisplay;
import com.rpglab.game.utils.InputManager;

public class Menu {

    public Menu() {
    }

    public int displayMenu(String title, String[] options) {
        System.out.println();
        System.out.println("====================  " + GameDisplay.BOLD + GameDisplay.YELLOW + title + GameDisplay.RESET + "  ====================");
        
        for (int i = 0; i < options.length; i++) {
            System.out.println("[" + (i + 1) + "]: " + options[i]);
        }
        
        System.out.println("==================================================================================");
        return InputManager.readWholeNumber("Input your choice", 1, options.length);
    }

    public int displayMainMenu() {
        String[] mainOptions = {"Start New Game", "Exit the game"};
        return displayMenu("DUNGEON ADVENTURE", mainOptions);
    }

    public void close() {
        InputManager.close();
    }
}
