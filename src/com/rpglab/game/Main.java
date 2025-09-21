package com.rpglab.game;

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

public class Main {

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

            // Implements hero selection
            Hero[] heroes = {
                new Mage("Wizard of Oz", 200, 15, 50, 0.8),
                new Archer("Artemis", 300, 10, 30, 0.8)
            };

            Hero hero = heroes[(int) (Math.random() * heroes.length)];

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

                    while (hero.isAlive() && monster.isAlive()) {
                        
                        System.out.println(GameDisplay.BOLD + "COMBAT STATUS:" + GameDisplay.RESET);
                        monster.showStatus();

                        
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

                                // try {
                                    if (hero.getWeapon().getDamage() < loot.getDamage()) {
                                        hero.equipWeapon(loot); 
                                    } else {
                                        System.out.println(GameDisplay.YELLOW + loot.getName() + " is not better than current weapon." + GameDisplay.RESET);
                                    }
                                // } catch (InvalidWeaponException e) {
                                //     System.out.println(GameDisplay.RED + "[Error] " + e.getMessage() + GameDisplay.RESET);
                                // } catch (NotEnoughResourceException e) {
                                //     System.out.println(GameDisplay.RED + "[Error] " + e.getMessage() + GameDisplay.RESET);
                                // }
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