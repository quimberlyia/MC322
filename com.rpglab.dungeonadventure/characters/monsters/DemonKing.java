package com.rpglab.dungeonadventure.characters.monsters;

import com.rpglab.dungeonadventure.battle.moves.DarkSlash;
import com.rpglab.dungeonadventure.battle.moves.DarkSpell;
import com.rpglab.dungeonadventure.characters.Monster;
import com.rpglab.dungeonadventure.items.Weapon;

public class DemonKing extends Monster {

    public DemonKing(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new DarkSlash());
        addAction(new DarkSpell());
    }
}
