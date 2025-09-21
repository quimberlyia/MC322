package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.FireBreath;
import com.rpglab.game.battle.moves.Roar;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

public class Dragon extends Monster {

    public Dragon(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new Roar());
        addAction(new FireBreath());
    }
}
