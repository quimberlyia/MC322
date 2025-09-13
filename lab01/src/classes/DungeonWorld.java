package classes;

import interfaces.World;
import enums.SceneType;
import classes.scenes.CombatScene;
import classes.Weapons.Bow;
import classes.Weapons.ExtremeSuperBow;
import classes.Weapons.MoonStaff;
import classes.Weapons.Staff;
import classes.Weapons.SuperBow;
import classes.Weapons.Sword;
import classes.Weapons.WillowStaff;
import classes.monsters.Cockatrice;
import classes.monsters.DemonKing;
import classes.monsters.Dragon;
import classes.monsters.Lizardman;
import classes.monsters.Skeleton;
import classes.monsters.Slime;

public class DungeonWorld implements World {

    CombatScene[] scenes;

    public DungeonWorld() {
        generateScenes(3);
        
        Weapon[] easyLoot = new Weapon[] { new Bow(), new Staff() };
        Weapon[] mediumLoot = new Weapon[] { new SuperBow(), new WillowStaff() };
        Weapon[] hardLoot = new Weapon[] { new ExtremeSuperBow(), new MoonStaff(), new Sword() };

        scenes[0] = new CombatScene(SceneType.DUNGEON_ENTRANCE, new Monster[] { 
            new Slime("Slime", 50, 5, 40, easyLoot),
            new Skeleton("Skeleton", 70, 10, 80, easyLoot),
            new Lizardman("Lizardman", 90, 15, 100, mediumLoot)
        });

        scenes[1] = new CombatScene(SceneType.DARK_HALLWAY, new Monster[] { 
            new Dragon("Dragon", 150, 35, 150, hardLoot),
            new Cockatrice("Cockatrice", 80, 30, 150, hardLoot)
        });

        scenes[2] = new CombatScene(SceneType.MONSTER_LAIR, new Monster[] { 
            new DemonKing("Demon King", 200, 50, 200, hardLoot)
        });
    }

    @Override
    public void generateScenes(int scenes_number) {
        this.scenes = new CombatScene[scenes_number];
    }

    public CombatScene[] getScenes() {
        return scenes;
    }
}
