// Import the Player class from the Player.java file
import classes.DungeonWorld;
import classes.Hero;
import classes.Monster;
import classes.scenes.CombatScene;
import classes.Weapon;
import classes.heroes.Archer;
import classes.heroes.Mage;
import interfaces.CombatAction;

public class main {
    public static void main(String[] args) {

        // Implements Dungeon World
        DungeonWorld dungeon = new DungeonWorld();

        // Implements hero selection
        Hero[] heroes = {
            new Mage("Wizard of Oz", 200, 15, 50, 0.8),
            new Archer("Artemis", 300, 10, 30, 0.8)
        };
        Hero hero = heroes[(int) (Math.random() * heroes.length)];

        for (CombatScene scene : dungeon.getScenes()) {

            scene.Start(hero);
            
            for (Monster monster : scene.getMonsters()) {
                System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println(">>>>> The " + monster.getName() + " is ready to slaughter the hero!");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");

                while (hero.isAlive() && monster.isAlive()) {
                    hero.showStatus();
                    monster.showStatus();

                    CombatAction heroAction = hero.chooseAction(monster);
                    CombatAction monsterAction = monster.chooseAction(hero);

                    // Execute actions
                    heroAction.execute(hero, monster);

                    if (monster.isAlive())
                        monsterAction.execute(monster, hero);
                }

                if (!hero.isAlive()) {
                    System.out.println("----------------------------------------------------\n");
                    System.out.println("The hero " + hero.getName() + " has been defeated! Game Over.");
                    return;
                }

                System.out.println("The hero " + hero.getName() + " has defeated the " + monster.getName() + "!");

                hero.gainExperience(monster.getExperience());
                if (Math.random() < hero.getLucky()) {
                    Weapon loot = (Weapon) monster.dropLoot();
                    System.out.println("Due to luck, " + hero.getName() + " found the " + loot.getName() + " on the " + monster.getName() + "!");
                    
                    if (hero.getWeapon().getDamage() < loot.getDamage()) {
                        hero.equipWeapon(loot);
                    } else {
                        System.out.println("But the " + loot.getName() + " is not better than the current weapon.");
                    }
                }
            }
            System.out.println("----------------------------------------------------");

            System.out.println("\n>>>>> The hero has cleared the floor!\n");
        }

        System.out.println("\n" + hero.getName() + " has defeated the Demon King and completed the dungeon!");
    }
}