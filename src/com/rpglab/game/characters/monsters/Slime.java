package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.AcidSpit;
import com.rpglab.game.battle.moves.Swallow;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

public class Slime extends Monster {

    public Slime(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new AcidSpit());
        addAction(new Swallow());
    }
}
