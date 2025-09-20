package com.rpglab.dungeonadventure.characters.monsters;

import com.rpglab.dungeonadventure.battle.moves.AcidSpit;
import com.rpglab.dungeonadventure.battle.moves.Swallow;
import com.rpglab.dungeonadventure.characters.Monster;
import com.rpglab.dungeonadventure.items.Weapon;

public class Slime extends Monster {

    public Slime(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new AcidSpit());
        addAction(new Swallow());
    }
}
