package com.rpglab.game.game;

import com.rpglab.game.characters.Hero;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.characters.heroes.Archer;
import com.rpglab.game.characters.heroes.Mage;
import com.rpglab.game.items.Weapon;
import com.rpglab.game.utils.GameDisplay;
import com.rpglab.game.enums.Difficulty;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.battle.moves.PowerfulSpell;
import com.rpglab.game.battle.moves.HealingPotion;
import com.rpglab.game.battle.moves.PreciseShot;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 * Represents a saved/active game session (Battle).
 * Stores the dungeon scenes, current phase index and the hero.
 * Also provides a helper to execute the next phase interactively.
 */
@XmlRootElement(name = "battle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Battle {

    @XmlTransient
    private CombatScene[] scenes;

    private int currentPhase = 0;

    private Hero hero;
    
    private Difficulty difficulty;

    public Battle() {}

    public Battle(Difficulty difficulty, Hero hero) {
        this.difficulty = difficulty;
        this.hero = hero;
        this.currentPhase = 0;
        this.scenes = null; // Will be generated on demand
    }

    public Battle(Difficulty difficulty, Hero hero, int currentPhase) {
        this.difficulty = difficulty;
        this.hero = hero;
        this.currentPhase = currentPhase;
        this.scenes = null; // Will be generated on demand
    }

    public CombatScene[] getScenes() { 
        if (scenes == null && difficulty != null) {
            // Generate scenes on demand from difficulty
            DungeonWorld dungeon = new DungeonWorld(difficulty);
            scenes = dungeon.getScenes();
        }
        return scenes; 
    }
    
    public Hero getHero() { return hero; }
    public int getCurrentPhase() { return currentPhase; }
    public Difficulty getDifficulty() { return difficulty; }

    /**
     * Create a new Battle (game session) from a difficulty and hero selection.
     * This keeps hero instantiation inside the Battle as requested.
     * @param difficulty chosen difficulty
     * @param heroChoice 1-based index for hero selection (1 = Mage, 2 = Archer)
     */
    public static Battle createNewGame(Difficulty difficulty, int heroChoice) {
        // Create shared combat action instances for heroes
        CombatAction powerfulSpell = new PowerfulSpell();
        CombatAction healingPotion = new HealingPotion();
        CombatAction preciseShot = new PreciseShot();
        
        Hero[] heroes = {
            new Mage("Wizard of Oz", 200, 15, 50, 0.8, new CombatAction[] { powerfulSpell, healingPotion }),
            new Archer("Artemis", 300, 10, 30, 0.8, new CombatAction[] { preciseShot, healingPotion })
        };
        int idx = Math.max(0, Math.min(heroes.length - 1, heroChoice - 1));
        Hero chosen = heroes[idx];
        return new Battle(difficulty, chosen, 0);
    }

    /**
     * Execute the next incomplete phase (scene). Returns true if game continues, false if finished/exit.
     */
    public boolean executeNextPhase(Menu menu) {
        // Generate scenes if needed (lazy loading from difficulty)
        CombatScene[] allScenes = getScenes();
        
        if (allScenes == null || currentPhase >= allScenes.length) return false;

        CombatScene scene = allScenes[currentPhase];
        scene.Start(hero);

        for (Monster monster : scene.getMonsters()) {
            System.out.println();
            System.out.println(GameDisplay.RED + GameDisplay.BOLD + "COMBAT ENCOUNTER" + GameDisplay.RESET);
            System.out.println(GameDisplay.RED + monster.getName() + " approaches for battle!" + GameDisplay.RESET);
            System.out.println("────────────────────────────────────────────────────────────────────");

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
                
                if (monster.isAlive()) {
                    monsterAction.execute(monster, hero);
                    
                    if (!hero.isAlive()) {
                        System.out.println(GameDisplay.BLUE + "└────────────────────────────────────────────────────────────────────┘" + GameDisplay.RESET);
                        System.out.println();
                        System.out.println(GameDisplay.RED + GameDisplay.BOLD + "DEFEAT" + GameDisplay.RESET);
                        System.out.println(GameDisplay.RED + "The hero " + hero.getName() + " has been defeated! Game Over." + GameDisplay.RESET);
                        System.out.println("────────────────────────────────────────────────────────────────────");
                        return false;
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

            while (true) {
                int battleChoice = menu.displayMenu("What's your next action?", new String[] {
                    "Search for loot",
                    "Check status",
                    "Continue gameplay",
                    "Save current gameplay",
                    "Exit current gameplay"
                });

                if (battleChoice == 5) {
                    // Exit the game
                    System.out.println("Exiting the game...");
                    return false;
                } else if (battleChoice == 4) {
                    // Save game - just save difficulty, hero, and currentPhase
                    String saveName = "savefile";//com.rpglab.game.utils.InputManager.readString("Save name: ");
                    Battle toSave = new Battle(difficulty, hero, currentPhase);
                    com.rpglab.game.utils.PersistenceGenerator.saveGame(toSave, saveName);
                } else if (battleChoice == 3) {
                    // Continue gameplay
                    break;
                } else if (battleChoice == 2) {
                    // Check status
                    hero.showStatus();
                    continue;
                } else if (battleChoice == 1) {
                    // Search for loot
                    if (searchedLoot) {
                        System.out.println("You already checked for loot.");
                        continue;
                    }
                    
                    searchedLoot = true;
                    
                    if (hasLoot) {
                        Weapon loot = (Weapon) monster.dropLoot();
                        System.out.println(GameDisplay.PURPLE + "Lucky find! " + hero.getName() + " found " + loot.getName() + " from " + monster.getName() + "!" + GameDisplay.RESET);
                        
                        try {
                            hero.equipWeapon(loot);
                        } catch (Exception e) {
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
        
        currentPhase++;
        return currentPhase < scenes.length;
    }
}
