// Import the Player class from the Player.java file
import classes.Hero;
import classes.Monster;
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

        // Initialize possible heroes
        Mage mage = new Mage("Gandalf, the mage", 100, 15, 50);
        Archer archer = new Archer("Legolas, the archer", 100, 10, 30);

        // Initialize possible monsters
        DemonKing demonKing =   new DemonKing("Demon King",     200, 50, 100);
        Dragon dragon =         new Dragon("Dragon",            150, 35, 80);
        Cockatrice cockatrice = new Cockatrice("Cockatrice",    80,  30, 20);
        Lizardman lizardman =   new Lizardman("Lizardman",      90,  15, 25);
        Skeleton skeleton =     new Skeleton("Skeleton",        70,  10, 15);
        Slime slime =           new Slime("Slime",              50,  5,  10);
        
        // Select one random hero
        Hero[] heroes = { mage, archer };
        Hero hero = heroes[(int) (Math.random() * 2)];

        System.out.println("The hero has entered the Castle of the Demon King to challenge the most evil creature in the world!");

        hero.showStatus();

        // Select the first floor monsters and second floor monsters. The third floor is the Demon King.
        Monster[] first_floorMonsters = { slime, skeleton, lizardman };
        Monster[] second_floorMonsters = { dragon, cockatrice };

        Monster[] monsters = { 
            first_floorMonsters[(int) (Math.random() * first_floorMonsters.length)], 
            second_floorMonsters[(int) (Math.random() * second_floorMonsters.length)], 
            demonKing
        };

        int floor = 0;
        for (Monster monster : monsters) {
            floor++;
            System.out.println("-------------------");
            System.out.println("The hero has entered the " + ( floor == 1 ? "first. Where is the first challenge?" : floor == 2 ? "second floor. What comes next?" : "final floor. The hero can feel an evil presence!!!" ));

            System.out.println("The " + monster.getName() + " is ready to slaughter the hero!");

            hero.attack(monster);
            monster.attack(hero);

            if (hero.getHealthPoints() == 0)
            {
                System.out.println("\n" + hero.getName() + " has been defeated! Game Over.");
                return;
            }

            System.out.println("-------------------");
            hero.showStatus();
            monster.showStatus();
            System.out.println("-------------------");
        }

        System.out.println("\n" + hero.getName() + " has defeated the Demon King and completed the dungeon!");
    }
}