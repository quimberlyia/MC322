package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.RustySword;
import com.rpglab.game.battle.moves.Tackle;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

public class Skeleton extends Monster {

    public Skeleton(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new RustySword());
        addAction(new Tackle());
    }
}
