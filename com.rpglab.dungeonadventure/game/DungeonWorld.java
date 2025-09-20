package com.rpglab.dungeonadventure.game;

import com.rpglab.dungeonadventure.characters.Monster;
import com.rpglab.dungeonadventure.characters.monsters.Cockatrice;
import com.rpglab.dungeonadventure.characters.monsters.DemonKing;
import com.rpglab.dungeonadventure.characters.monsters.Dragon;
import com.rpglab.dungeonadventure.characters.monsters.Lizardman;
import com.rpglab.dungeonadventure.characters.monsters.Skeleton;
import com.rpglab.dungeonadventure.characters.monsters.Slime;
import com.rpglab.dungeonadventure.enums.SceneType;
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
