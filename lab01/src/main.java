// Import the Player class from the Player.java file
import classes.BuildScene;
import classes.Hero;
import classes.Monster;
import classes.Scene;
import classes.heroes.Archer;
import classes.heroes.Mage;
import classes.monsters.Cockatrice;
import classes.monsters.DemonKing;
import classes.monsters.Lizardman;
import classes.monsters.Dragon;
import classes.monsters.Slime;
import classes.monsters.Skeleton;

public class main {
    public static void main(String[] args) {

        // Generates the game scenario
        Scene[] scenes = BuildScene.generateScenes(3);

        scenes[0].setEnvironment("Dungeon Entrance");

        scenes[0].setMonsters(new Monster[] { 
            new Slime("Slime", 50, 5, 10),
            new Skeleton("Skeleton", 70, 10, 15),
            new Lizardman("Lizardman", 90, 15, 25)
        });

        scenes[1].setEnvironment("Dark Hallway");

        scenes[1].setMonsters(new Monster[] { 
            new Dragon("Dragon", 150, 35, 80),
            new Cockatrice("Cockatrice", 80, 30, 20)
        });

        scenes[2].setEnvironment("Demon King's Lair");

        scenes[2].setMonsters(new Monster[] { 
            new DemonKing("Demon King", 200, 50, 100)
        });

        // Initialize possible heroes
        Mage mage = new Mage("Wizard of Oz", 200, 15, 50, 0.5);
        Archer archer = new Archer("Artemis", 300, 10, 30, 0.3);

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

                //TODO: Run hero lucky, then use drop weapon of monster if lucky
                //TODO: If new weapon better than current, get new weapon
            }
            System.out.println("----------------------------------------------------");

            System.out.println("\n>>>>> The hero has cleared the " + scene.getEnvironment() + "!\n");
        }

        System.out.println("\n" + hero.getName() + " has defeated the Demon King and completed the dungeon!");
    }
}