package com.rpglab.dungeonadventure.characters.monsters;

import com.rpglab.dungeonadventure.battle.moves.FireBreath;
import com.rpglab.dungeonadventure.battle.moves.Roar;
import com.rpglab.dungeonadventure.characters.Monster;
import com.rpglab.dungeonadventure.items.Weapon;

public class Dragon extends Monster {

    public Dragon(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new Roar());
        addAction(new FireBreath());
    }
}
