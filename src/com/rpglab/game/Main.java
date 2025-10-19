package com.rpglab.game;

import com.rpglab.game.battle.moves.*;
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
            int gameChoice = menu.displayMenu("Dungeon Adventure Menu", new String[] {"Start Game", "Exit Game"});

            if (gameChoice == 2)
            {
                // Exit the game
                System.out.println("Exiting the game...");
                return;
            }

            int difficultyChoice = menu.displayMenu("Select Difficulty", new String[] {"Easy", "Medium", "Hard"});
            Difficulty difficulty = Difficulty.values()[difficultyChoice - 1];

            // Implements Dungeon World
            DungeonWorld dungeon = new DungeonWorld(difficulty);

            // Create shared combat action instances for heroes
            CombatAction powerfulSpell = new PowerfulSpell();
            CombatAction healingPotion = new HealingPotion();
            CombatAction preciseShot = new PreciseShot();

            // Implements hero selection
            Hero[] heroes = {
                new Mage("Wizard of Oz", 200, 15, 50, 0.8, new CombatAction[] { powerfulSpell, healingPotion }),
                new Archer("Artemis", 300, 10, 30, 0.8, new CombatAction[] { preciseShot, healingPotion })
            };

            int heroChoice = menu.displayMenu("Select Your Hero", new String[] {"Mage - Wizard of Oz", "Archer - Artemis"});

            Hero hero = heroes[heroChoice - 1];

            System.out.println();
            System.out.println(GameDisplay.BOLD + GameDisplay.YELLOW + "DUNGEON ADVENTURE BEGINS" + GameDisplay.RESET);

            System.out.println(GameDisplay.BLUE + "The hero " + hero.getName() + " has begun a new adventure against the Demon King!" + GameDisplay.RESET);
            System.out.println("────────────────────────────────────────────────────────────────────");

            for (CombatScene scene : dungeon.getScenes()) {

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
                            "Search for loot",
                            "Check status",
                            "Continue game",
                            "Exit game"
                        });

                        if (battleChoice == 4)
                        {
                            // Exit the game
                            System.out.println("Exiting the game...");
                            return;
                        } else if (battleChoice == 3)
                        {
                            break;
                        }
                        else if (battleChoice == 2)
                        {
                            hero.showStatus();
                            continue;
                        } else if (battleChoice == 1)
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
    }
}