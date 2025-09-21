package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.DarkSlash;
import com.rpglab.game.battle.moves.DarkSpell;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

public class DemonKing extends Monster {

    public DemonKing(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new DarkSlash());
        addAction(new DarkSpell());
    }
}
