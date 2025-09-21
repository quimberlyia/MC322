package classes;

import interfaces.World;
import enums.SceneType;
import enums.Dificult;
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

    public DungeonWorld(Dificult dificult) {
        generateScenes(3);

        double lifeMult = dificult.getLifeMult();
        double damageMult = dificult.getDamageMult();
        
        Weapon[] easyLoot = new Weapon[] { new Bow(), new Staff() };
        Weapon[] mediumLoot = new Weapon[] { new SuperBow(), new WillowStaff() };
        Weapon[] hardLoot = new Weapon[] { new ExtremeSuperBow(), new MoonStaff(), new Sword() };

          scenes[0] = new CombatScene(SceneType.DUNGEON_ENTRANCE, new Monster[] {
            new Slime("Slime", 
                newValue(50, lifeMult), // vida ajustada
                newValue(5, damageMult), // dano ajustado
                40, 
                easyLoot
            ),
            new Skeleton("Skeleton", 
                newValue(70, lifeMult),
                newValue(10, damageMult),
                80,
                easyLoot
            ),
            new Lizardman("Lizardman",
                newValue(90, lifeMult),
                newValue(15, damageMult),
                100,
                mediumLoot
            )
        });

        scenes[1] = new CombatScene(SceneType.DARK_HALLWAY, new Monster[] {
            new Dragon("Dragon",
                newValue(150, lifeMult),
                newValue(35, damageMult),
                150,
                hardLoot
            ),
            new Cockatrice("Cockatrice",
                newValue(80, lifeMult),
                newValue(30, damageMult),
                150,
                hardLoot
            )
        });

        scenes[2] = new CombatScene(SceneType.MONSTER_LAIR, new Monster[] {
            new DemonKing("Demon King",
                newValue(200, lifeMult),
                newValue(50, damageMult),
                200,
                hardLoot
            )
        });
    }

    @Override
    public void generateScenes(int scenes_number) {
        this.scenes = new CombatScene[scenes_number];
    }

    public CombatScene[] getScenes() {
        return scenes;
    }

    private int newValue(int baseValue, double multiplier) {
    return (int) (baseValue * multiplier);
}   
}
