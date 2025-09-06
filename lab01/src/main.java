// Import the Player class from the Player.java file
import classes.BuildScene;
import classes.Hero;
import classes.Monster;
import classes.Scene;
import classes.Weapon;
import classes.heroes.Archer;
import classes.heroes.Mage;
import classes.monsters.Cockatrice;
import classes.monsters.DemonKing;
import classes.monsters.Lizardman;
import classes.monsters.Dragon;
import classes.monsters.Slime;
import classes.monsters.Skeleton;
import classes.Weapons.*;

public class main {
    public static void main(String[] args) {

        Weapon[] easyLoot = new Weapon[] { new Bow(), new Staff() };
        Weapon[] mediumLoot = new Weapon[] { new SuperBow(), new WillowStaff() };
        Weapon[] hardLoot = new Weapon[] { new ExtremeSuperBow(), new MoonStaff(), new Sword() };

        // Generates the game scenario
        Scene[] scenes = BuildScene.generateScenes(3);

        scenes[0].setEnvironment("Dungeon Entrance");

        scenes[0].setMonsters(new Monster[] { 
            new Slime("Slime", 50, 5, 10, easyLoot),
            new Skeleton("Skeleton", 70, 10, 15, easyLoot),
            new Lizardman("Lizardman", 90, 15, 25, mediumLoot)
        });

        scenes[1].setEnvironment("Dark Hallway");

        scenes[1].setMonsters(new Monster[] { 
            new Dragon("Dragon", 150, 35, 80, hardLoot),
            new Cockatrice("Cockatrice", 80, 30, 20, hardLoot)
        });

        scenes[2].setEnvironment("Demon King's Lair");

        scenes[2].setMonsters(new Monster[] { 
            new DemonKing("Demon King", 200, 50, 100, hardLoot)
        });

        // Initialize possible heroes
        Mage mage = new Mage("Wizard of Oz", 200, 15, 50, 0.8);
        Archer archer = new Archer("Artemis", 300, 10, 30, 0.8);

        // Select one random hero
        Hero[] heroes = { mage, archer };
        Hero hero = heroes[(int) (Math.random() * 2)];
        
        System.out.println("The hero has entered the Castle of the Demon King to challenge the most evil creature in the world!");
        
        for (Scene scene : scenes) {
            System.out.println("====================================================================================");
            System.out.println("=============== The hero has entered the " + scene.getEnvironment() + "!");
            System.out.println("====================================================================================\n");
            
            hero.showStatus();

            for (Monster monster : scene.getMonsters()) {
                System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println(">>>>> The " + monster.getName() + " is ready to slaughter the hero!");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
                monster.showStatus();

                System.out.println("\n----------------------------------------------------");
                while (hero.getHealthPoints() > 0 && monster.getHealthPoints() > 0) {
                    hero.attack(monster);
                    if (monster.getHealthPoints() > 0) {
                        monster.attack(hero);
                    }
                }

                if (hero.getHealthPoints() <= 0) {
                    
                    System.out.println("----------------------------------------------------\n");
                    System.out.println("The hero " + hero.getName() + " has been defeated! Game Over.");
                    return;
                }

                System.out.println("The hero " + hero.getName() + " has defeated the " + monster.getName() + "!");
                
                hero.gainExperience(monster.getExperience());

                if (Math.random() < hero.getLucky()) {
                    Weapon loot = monster.dropLoot();
                    System.out.println("Due to luck, " + hero.getName() + " found the " + loot.getName() + " on the " + monster.getName() + "!");
                    
                    if (hero.getWeapon().getDamage() < loot.getDamage()) {
                        hero.equipWeapon(loot);
                    } else {
                        System.out.println("But the " + loot.getName() + " is not better than the current weapon.");
                    }
                }

            }
            System.out.println("----------------------------------------------------");

            System.out.println("\n>>>>> The hero has cleared the " + scene.getEnvironment() + "!\n");
        }

        System.out.println("\n" + hero.getName() + " has defeated the Demon King and completed the dungeon!");
    }
}