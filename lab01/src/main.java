// Import the Player class from the Player.java file
import classes.DungeonWorld;
import classes.GameDisplay;
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
                    System.out.println(GameDisplay.BLUE + "┌─ TURN ─────────────────────────────────────────────────────────────┐" + GameDisplay.RESET);
                    
                    System.out.println(GameDisplay.BOLD + "COMBAT STATUS:" + GameDisplay.RESET);
                    hero.showStatus();
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
                if (Math.random() < hero.getLucky()) {
                    Weapon loot = (Weapon) monster.dropLoot();
                    System.out.println(GameDisplay.PURPLE + "Lucky find! " + hero.getName() + " found " + loot.getName() + " from " + monster.getName() + "!" + GameDisplay.RESET);

                    if (hero.getWeapon().getDamage() < loot.getDamage()) {
                        hero.equipWeapon(loot);
                    } else {
                        System.out.println(GameDisplay.YELLOW + loot.getName() + " is not better than current weapon." + GameDisplay.RESET);
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