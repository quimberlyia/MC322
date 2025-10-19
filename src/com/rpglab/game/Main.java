package com.rpglab.game;

import com.rpglab.game.characters.Hero;
import com.rpglab.game.enums.Difficulty;
import com.rpglab.game.game.Menu;
import com.rpglab.game.utils.PersistenceGenerator;
import com.rpglab.game.game.Battle;
import com.rpglab.game.utils.GameDisplay;

/**
 * Main class that serves as the entry point for the Dungeon Adventure RPG.
 * This class orchestrates the entire game flow, from menu navigation to combat
 * encounters and final victory conditions.
 * 
 * <p>The game features:</p>
 * <ul>
 *   <li>Multiple difficulty levels affecting game balance</li>
 *   <li>Hero selection between Mage and Archer classes</li>
 *   <li>Turn-based combat system with various actions</li>
 *   <li>Experience and leveling system</li>
 *   <li>Loot collection and weapon upgrading</li>
 *   <li>Progressive dungeon exploration</li>
 * </ul>
 * 
 * <p>The game loop handles menu interactions, combat encounters, character progression,
 * and provides a complete adventure experience culminating in the defeat of the Demon King.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Main {

    /**
     * Main method that starts and runs the Dungeon Adventure RPG.
     * Handles the complete game flow including menu navigation, difficulty selection,
     * hero assignment, dungeon exploration, combat encounters, and victory conditions.
     * 
     * <p>Game Flow:</p>
     * <ol>
     *   <li>Display main menu and handle user choices</li>
     *   <li>Allow difficulty selection (Easy, Medium, Hard)</li>
     *   <li>Generate dungeon world based on selected difficulty</li>
     *   <li>Randomly assign a hero (Mage or Archer) to the player</li>
     *   <li>Process each combat scene with monsters</li>
     *   <li>Handle combat actions, experience gain, and loot collection</li>
     *   <li>Progress through the dungeon until completion or defeat</li>
     * </ol>
     * 
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {

        Menu menu = new Menu();

        while (true)
        {
            // Main menu options
            String[] mainOptions = new String[] {"Start Game", "Load Saved Game", "Exit Game"};
            int gameChoice = menu.displayMenu("Dungeon Adventure Menu", mainOptions);

            if (gameChoice == 3) {
                System.out.println("Exiting the game...");
                return;
            }
            
            if (gameChoice == 2) {
                String name = "savefile";//com.rpglab.game.utils.InputManager.readString("Enter saved game name: ");
                Battle batalha = PersistenceGenerator.loadGame(name);
                if (batalha == null) {
                    System.out.println("Não foi possível carregar o jogo: " + name);
                    continue;
                }
                
                // Run loaded battle using executeNextPhase
                while (batalha.executeNextPhase(menu)) {
                    // Continue executing phases until game ends or user exits
                }
                
                // Check if game was completed
                if (batalha.getCurrentPhase() >= batalha.getScenes().length) {
                    System.out.println();
                    System.out.println(GameDisplay.YELLOW + GameDisplay.BOLD + "GAME COMPLETE!" + GameDisplay.RESET);
                    System.out.println(GameDisplay.YELLOW + batalha.getHero().getName() + " has defeated the Demon King and completed the dungeon!" + GameDisplay.RESET);
                    System.out.println("────────────────────────────────────────────────────────────────────");
                }
                continue;
            }

            // if reached here, Start Game selected
            int difficultyChoice = menu.displayMenu("Select Difficulty", new String[] {"Easy", "Medium", "Hard"});
            Difficulty difficulty = Difficulty.values()[difficultyChoice - 1];

            int heroChoice = menu.displayMenu("Select Your Hero", new String[] {"Mage - Wizard of Oz", "Archer - Artemis"});

            // Create new battle with selected difficulty and hero
            Battle battle = Battle.createNewGame(difficulty, heroChoice);
            Hero hero = battle.getHero();

            System.out.println();
            System.out.println(GameDisplay.BOLD + GameDisplay.YELLOW + "DUNGEON ADVENTURE BEGINS" + GameDisplay.RESET);
            System.out.println(GameDisplay.BLUE + "The hero " + hero.getName() + " has begun a new adventure against the Demon King!" + GameDisplay.RESET);
            System.out.println("────────────────────────────────────────────────────────────────────");

            // Execute all phases using Battle class
            while (battle.executeNextPhase(menu)) {
                // Continue executing phases until game ends or user exits
            }

            // Check if game was completed
            if (battle.getCurrentPhase() >= battle.getScenes().length) {
                System.out.println();
                System.out.println(GameDisplay.YELLOW + GameDisplay.BOLD + "GAME COMPLETE!" + GameDisplay.RESET);
                System.out.println(GameDisplay.YELLOW + hero.getName() + " has defeated the Demon King and completed the dungeon!" + GameDisplay.RESET);
                System.out.println("────────────────────────────────────────────────────────────────────");
            }
        }
    }
}