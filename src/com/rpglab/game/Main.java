package com.rpglab.game;

import com.rpglab.game.Exceptions.InvalidWeaponException;
import com.rpglab.game.characters.Hero;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.characters.heroes.Archer;
import com.rpglab.game.characters.heroes.Mage;
import com.rpglab.game.enums.Difficulty;
import com.rpglab.game.game.CombatScene;
import com.rpglab.game.game.DungeonWorld;
import com.rpglab.game.game.Menu;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.items.Weapon;
import java.io.File;
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
            // check if saves exist to show Load option
            File savesDir = new File("saves");
            boolean hasSaves = savesDir.exists() && savesDir.listFiles() != null && savesDir.listFiles().length > 0;
            String[] mainOptions = hasSaves ? new String[] {"Start Game", "Load Saved Game", "Exit Game"} : new String[] {"Start Game", "Exit Game"};
            int gameChoice = menu.displayMenu("Dungeon Adventure Menu", mainOptions);

            if (!hasSaves) {
                if (gameChoice == 2) {
                    System.out.println("Exiting the game...");
                    return;
                }
            } else {
                if (gameChoice == 3) {
                    System.out.println("Exiting the game...");
                    return;
                }
                if (gameChoice == 2) {
                    String name = com.rpglab.game.utils.InputManager.readString("Enter saved game name: ");
                    Battle batalha = PersistenceGenerator.loadGame(name);
                    if (batalha == null) {
                        System.out.println("Não foi possível carregar o jogo: " + name);
                        continue;
                    }
                    // run loaded battle
                    Hero hero = batalha.getHero();
                    CombatScene[] scenes = batalha.getScenes();
                    int startPhase = batalha.getCurrentPhase();
                    for (int si = startPhase; si < scenes.length; si++) {
                        CombatScene scene = scenes[si];
                        scene.Start(hero);
                        for (Monster monster : scene.getMonsters()) {
                            System.out.println();
                            System.out.println(GameDisplay.RED + GameDisplay.BOLD + "COMBAT ENCOUNTER" + GameDisplay.RESET);
                            System.out.println(GameDisplay.RED + monster.getName() + " approaches for battle!" + GameDisplay.RESET);

                            while (hero.isAlive() && monster.isAlive()) {
                                monster.showStatus();
                                hero.showStatus();
                                CombatAction heroAction = hero.chooseAction(monster);
                                CombatAction monsterAction = monster.chooseAction(hero);
                                heroAction.execute(hero, monster);
                                if (monster.isAlive()) {
                                    monsterAction.execute(monster, hero);
                                    if (!hero.isAlive()) {
                                        System.out.println(GameDisplay.RED + "Hero defeated. Game over." + GameDisplay.RESET);
                                        return;
                                    }
                                }
                            }

                            hero.gainExperience(monster.getExperience());

                            boolean searchedLoot = false;
                            boolean hasLoot = Math.random() < hero.getLucky();

                            while (true) {
                                int battleChoice = menu.displayMenu("What's your next action?", new String[] {
                                    "Save Game",
                                    "Search for loot",
                                    "Check status",
                                    "Continue game",
                                    "Exit game"
                                });

                                if (battleChoice == 5) return;
                                if (battleChoice == 4) break;
                                if (battleChoice == 3) { hero.showStatus(); continue; }
                                if (battleChoice == 2) {
                                    if (searchedLoot) { System.out.println("You already checked for loot."); continue; }
                                    searchedLoot = true;
                                    if (hasLoot) {
                                        Weapon loot = (Weapon) monster.dropLoot();
                                        System.out.println(GameDisplay.PURPLE + "Lucky find! " + hero.getName() + " found " + loot.getName() + " from " + monster.getName() + "!" + GameDisplay.RESET);
                                        try { hero.equipWeapon(loot); } catch (InvalidWeaponException e) { System.out.println(GameDisplay.RED + e.getMessage() + GameDisplay.RESET); }
                                    } else { System.out.println("Bad luck! You didn't find any loot."); }
                                    continue;
                                }
                                // Save Game
                                if (battleChoice == 1) {
                                    String saveName = com.rpglab.game.utils.InputManager.readString("Save name: ");
                                    Battle toSave = new Battle(scenes, hero, si);
                                    PersistenceGenerator.saveGame(toSave, saveName);
                                    continue;
                                }
                            }
                        }
                        System.out.println();
                        System.out.println(GameDisplay.GREEN + GameDisplay.BOLD + "FLOOR CLEARED!" + GameDisplay.RESET);
                        System.out.println("────────────────────────────────────────────────────────────────────");
                    }
                    System.out.println(GameDisplay.YELLOW + GameDisplay.BOLD + "GAME COMPLETE!" + GameDisplay.RESET);
                    return;
                }
            }

            // if reached here, Start Game selected
            int difficultyChoice = menu.displayMenu("Select Difficulty", new String[] {"Easy", "Medium", "Hard"});
            Difficulty difficulty = Difficulty.values()[difficultyChoice - 1];
            // DungeonWorld will be created inside Battle.createNewGame

            int heroChoice = menu.displayMenu("Select Your Hero", new String[] {"Mage - Wizard of Oz", "Archer - Artemis"});

            Hero hero = heroes[heroChoice - 1];

            System.out.println();
            System.out.println(GameDisplay.BOLD + GameDisplay.YELLOW + "DUNGEON ADVENTURE BEGINS" + GameDisplay.RESET);

            System.out.println(GameDisplay.BLUE + "The hero " + hero.getName() + " has begun a new adventure against the Demon King!" + GameDisplay.RESET);
            System.out.println("────────────────────────────────────────────────────────────────────");

            CombatScene[] scenes = dungeon.getScenes();
            for (int si = 0; si < scenes.length; si++) {
                CombatScene scene = scenes[si];
                scene.Start(hero);
                for (Monster monster : scene.getMonsters()) {
                    System.out.println();
                    System.out.println(GameDisplay.RED + GameDisplay.BOLD + "COMBAT ENCOUNTER" + GameDisplay.RESET);
                    System.out.println(GameDisplay.RED + monster.getName() + " approaches for battle!" + GameDisplay.RESET);
                    System.out.println("────────────────────────────────────────────────────────────────────");

                    // menu.getInputManager().waitForEnter("Press Enter to continue...");

                    while (hero.isAlive() && monster.isAlive()) {
                        System.out.println(GameDisplay.BLUE + "┌─ TURN ─────────────────────────────────────────────────────────────┐" + GameDisplay.RESET);
                        System.out.println(GameDisplay.BOLD + "COMBAT STATUS:" + GameDisplay.RESET);
                        monster.showStatus();
                        hero.showStatus();

                        
                        CombatAction heroAction = hero.chooseAction(monster);
                        CombatAction monsterAction = monster.chooseAction(hero);
                        
                        // Execute actions
                        System.out.println(GameDisplay.BOLD + "ACTIONS:" + GameDisplay.RESET);
                        heroAction.execute(hero, monster);
                        
                        if (monster.isAlive())
                        {
                            monsterAction.execute(monster, hero);
                            
                            if (!hero.isAlive()) {
                                System.out.println(GameDisplay.BLUE + "└────────────────────────────────────────────────────────────────────┘" + GameDisplay.RESET);
                                System.out.println();
                                System.out.println(GameDisplay.RED + GameDisplay.BOLD + "DEFEAT" + GameDisplay.RESET);
                                System.out.println(GameDisplay.RED + "The hero " + hero.getName() + " has been defeated! Game Over." + GameDisplay.RESET);
                                System.out.println("────────────────────────────────────────────────────────────────────");
                                return;
                            }
                        }
                        
                        System.out.println(GameDisplay.BLUE + "└────────────────────────────────────────────────────────────────────┘" + GameDisplay.RESET);
                        System.out.println();
                        // menu.getInputManager().waitForEnter("Press Enter to continue...");
                    }

                    System.out.println();
                    System.out.println(GameDisplay.GREEN + GameDisplay.BOLD + "VICTORY!" + GameDisplay.RESET);
                    System.out.println(GameDisplay.GREEN + hero.getName() + " has defeated the " + monster.getName() + "!" + GameDisplay.RESET);
                    System.out.println("────────────────────────────────────────────────────────────────────");
                    
                    hero.gainExperience(monster.getExperience());

                    boolean searchedLoot = false;
                    boolean hasLoot = Math.random() < hero.getLucky();
                    
                    while(true)
                    {
                        int battleChoice = menu.displayMenu("What's your next action?", new String[] {
                            "Save Game",
                            "Search for loot",
                            "Check status",
                            "Continue game",
                            "Exit game"
                        });

                        if (battleChoice == 5)
                        {
                            // Exit the game
                            System.out.println("Exiting the game...");
                            return;
                        } else if (battleChoice == 4)
                        {
                            break;
                        }
                        else if (battleChoice == 3)
                        {
                            hero.showStatus();
                            continue;
                        } else if (battleChoice == 2)
                        {
                            if (searchedLoot)
                            {
                                System.out.println("You already checked for loot.");
                                continue;
                            }

                            searchedLoot = true;

                            if (hasLoot) {
                                Weapon loot = (Weapon) monster.dropLoot();
                                System.out.println(GameDisplay.PURPLE + "Lucky find! " + hero.getName() + " found " + loot.getName() + " from " + monster.getName() + "!" + GameDisplay.RESET);

                                try {
                                    hero.equipWeapon(loot);
                                } catch (InvalidWeaponException e) {
                                    System.out.println(GameDisplay.RED + e.getMessage() + GameDisplay.RESET);
                                }
                            } else {
                                System.out.println("Bad luck! You didn't find any loot.");
                            }
                        } else if (battleChoice == 1) {
                            // Save game
                            String saveName = com.rpglab.game.utils.InputManager.readString("Save name: ");
                            Battle toSave = new Battle(scenes, hero, si);
                            PersistenceGenerator.saveGame(toSave, saveName);
                        }
                    }
                }
                
                System.out.println();
                System.out.println(GameDisplay.GREEN + GameDisplay.BOLD + "FLOOR CLEARED!" + GameDisplay.RESET);
                System.out.println("────────────────────────────────────────────────────────────────────");
            }

            System.out.println();
            System.out.println(GameDisplay.YELLOW + GameDisplay.BOLD + "GAME COMPLETE!" + GameDisplay.RESET);
            System.out.println(GameDisplay.YELLOW + hero.getName() + " has defeated the Demon King and completed the dungeon!" + GameDisplay.RESET);
            System.out.println("────────────────────────────────────────────────────────────────────");
        }

        // Optional demo: save/load the first combat scene (set to true to run)
        boolean DEMO_SAVE_LOAD = false; // change to true to test persistence
        if (DEMO_SAVE_LOAD) {
            try {
                com.rpglab.game.utils.PersistenceGenerator.saveBattle(dungeon.getScenes()[0], "demo_battle");
                com.rpglab.game.game.CombatScene loaded = com.rpglab.game.utils.PersistenceGenerator.loadBattle("demo_battle");
                if (loaded != null) {
                    System.out.println("Loaded scene type: " + loaded.getSceneType().getDescription());
                    System.out.println("Monsters in loaded scene: " + loaded.getMonsters().length);
                }
            } catch (Exception e) {
                System.err.println("Erro no demo de salvar/carregar: " + e.getMessage());
            }
        }
    }
}