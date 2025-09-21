package com.rpglab.game.game;

import com.rpglab.game.characters.Monster;
import com.rpglab.game.characters.monsters.Cockatrice;
import com.rpglab.game.characters.monsters.DemonKing;
import com.rpglab.game.characters.monsters.Dragon;
import com.rpglab.game.characters.monsters.Lizardman;
import com.rpglab.game.characters.monsters.Skeleton;
import com.rpglab.game.characters.monsters.Slime;
import com.rpglab.game.enums.SceneType;
import com.rpglab.game.enums.Difficulty;
import com.rpglab.game.interfaces.World;
import com.rpglab.game.items.Weapon;
import com.rpglab.game.items.weapons.Bow;
import com.rpglab.game.items.weapons.ExtremeSuperBow;
import com.rpglab.game.items.weapons.MoonStaff;
import com.rpglab.game.items.weapons.Staff;
import com.rpglab.game.items.weapons.SuperBow;
import com.rpglab.game.items.weapons.Sword;
import com.rpglab.game.items.weapons.WillowStaff;

public class DungeonWorld implements World {

    CombatScene[] scenes;

    public DungeonWorld(Difficulty Difficulty) {
        generateScenes(3);

        double lifeMult = Difficulty.getLifeMult();
        double damageMult = Difficulty.getDamageMult();
        
        Weapon[] easyLoot = new Weapon[] { new Bow(), new Staff() };
        Weapon[] mediumLoot = new Weapon[] { new SuperBow(), new WillowStaff() };
        Weapon[] hardLoot = new Weapon[] { new ExtremeSuperBow(), new MoonStaff(), new Sword() };

          scenes[0] = new CombatScene(SceneType.DUNGEON_ENTRANCE, new Monster[] {
            new Slime("Slime", 
                newValue(50, lifeMult), // adjusted life
                newValue(5, damageMult), // adjusted damage
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
