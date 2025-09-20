package com.rpglab.dungeonadventure.characters.monsters;

import com.rpglab.dungeonadventure.battle.moves.RustySword;
import com.rpglab.dungeonadventure.battle.moves.Tackle;
import com.rpglab.dungeonadventure.characters.Monster;
import com.rpglab.dungeonadventure.items.Weapon;

public class Skeleton extends Monster {

    public Skeleton(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new RustySword());
        addAction(new Tackle());
    }
}
