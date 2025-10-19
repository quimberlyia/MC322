package com.rpglab.game.game;

import com.rpglab.game.characters.Hero;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.characters.heroes.Archer;
import com.rpglab.game.characters.heroes.Mage;
import com.rpglab.game.items.Weapon;
import com.rpglab.game.utils.GameDisplay;
import com.rpglab.game.enums.Difficulty;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a saved/active game session (Battle).
 * Stores the dungeon scenes, current phase index and the hero.
 * Also provides a helper to execute the next phase interactively.
 */
@XmlRootElement(name = "battle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Battle {

    @XmlElementWrapper(name = "scenes")
    @XmlElement(name = "scene")
    private CombatScene[] scenes;

    private int currentPhase = 0;

    private Hero hero;

    public Battle() {}

    public Battle(CombatScene[] scenes, Hero hero) {
        this.scenes = scenes;
        this.hero = hero;
        this.currentPhase = 0;
    }

    public Battle(CombatScene[] scenes, Hero hero, int currentPhase) {
        this.scenes = scenes;
        this.hero = hero;
        this.currentPhase = currentPhase;
    }

    public CombatScene[] getScenes() { return scenes; }
    public Hero getHero() { return hero; }
    public int getCurrentPhase() { return currentPhase; }

    /**
     * Create a new Battle (game session) from a difficulty and hero selection.
     * This keeps hero instantiation inside the Battle as requested.
     * @param difficulty chosen difficulty
     * @param heroChoice 1-based index for hero selection (1 = Mage, 2 = Archer)
     */
    public static Battle createNewGame(Difficulty difficulty, int heroChoice) {
        DungeonWorld dungeon = new DungeonWorld(difficulty);
        Hero[] heroes = {
            new Mage("Wizard of Oz", 200, 15, 50, 0.8),
            new Archer("Artemis", 300, 10, 30, 0.8)
        };
        int idx = Math.max(0, Math.min(heroes.length - 1, heroChoice - 1));
        Hero chosen = heroes[idx];
        CombatScene[] scenes = dungeon.getScenes();
        return new Battle(scenes, chosen, 0);
    }

    /**
     * Execute the next incomplete phase (scene). Returns true if game continues, false if finished/exit.
     */
    public boolean executeNextPhase(Menu menu) {
        if (scenes == null || currentPhase >= scenes.length) return false;

        CombatScene scene = scenes[currentPhase];
        scene.Start(hero);

        for (Monster monster : scene.getMonsters()) {
            System.out.println();
            System.out.println(GameDisplay.RED + GameDisplay.BOLD + "COMBAT ENCOUNTER" + GameDisplay.RESET);
            System.out.println(GameDisplay.RED + monster.getName() + " approaches for battle!" + GameDisplay.RESET);

            while (hero.isAlive() && monster.isAlive()) {
                monster.showStatus();
                hero.showStatus();

                com.rpglab.game.interfaces.CombatAction heroAction = hero.chooseAction(monster);
                com.rpglab.game.interfaces.CombatAction monsterAction = monster.chooseAction(hero);

                heroAction.execute(hero, monster);
                if (monster.isAlive()) {
                    monsterAction.execute(monster, hero);
                    if (!hero.isAlive()) {
                        System.out.println(GameDisplay.RED + "Hero defeated. Game over." + GameDisplay.RESET);
                        return false;
                    }
                }
            }

            System.out.println(GameDisplay.GREEN + "VICTORY!" + GameDisplay.RESET);
            hero.gainExperience(monster.getExperience());

            boolean searchedLoot = false;
            boolean hasLoot = Math.random() < hero.getLucky();

            while (true) {
                int battleChoice = menu.displayMenu("What's your next action?", new String[] {
                    "Search for loot",
                    "Check status",
                    "Continue game",
                    "Exit game"
                });

                if (battleChoice == 4) {
                    return false;
                } else if (battleChoice == 3) {
                    break;
                } else if (battleChoice == 2) {
                    hero.showStatus();
                    continue;
                } else if (battleChoice == 1) {
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

        currentPhase++;
        return currentPhase < scenes.length;
    }
}
