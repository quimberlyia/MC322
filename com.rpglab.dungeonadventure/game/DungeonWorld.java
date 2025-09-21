package com.rpglab.dungeonadventure.game;

import com.rpglab.dungeonadventure.characters.Monster;
import com.rpglab.dungeonadventure.characters.monsters.Cockatrice;
import com.rpglab.dungeonadventure.characters.monsters.DemonKing;
import com.rpglab.dungeonadventure.characters.monsters.Dragon;
import com.rpglab.dungeonadventure.characters.monsters.Lizardman;
import com.rpglab.dungeonadventure.characters.monsters.Skeleton;
import com.rpglab.dungeonadventure.characters.monsters.Slime;
import com.rpglab.dungeonadventure.enums.SceneType;
import com.rpglab.dungeonadventure.enums.Difficulty;
import com.rpglab.dungeonadventure.game.CombatScene;
import com.rpglab.dungeonadventure.interfaces.World;
import com.rpglab.dungeonadventure.items.Weapon;
import com.rpglab.dungeonadventure.items.weapons.Bow;
import com.rpglab.dungeonadventure.items.weapons.ExtremeSuperBow;
import com.rpglab.dungeonadventure.items.weapons.MoonStaff;
import com.rpglab.dungeonadventure.items.weapons.Staff;
import com.rpglab.dungeonadventure.items.weapons.SuperBow;
import com.rpglab.dungeonadventure.items.weapons.Sword;
import com.rpglab.dungeonadventure.items.weapons.WillowStaff;

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
