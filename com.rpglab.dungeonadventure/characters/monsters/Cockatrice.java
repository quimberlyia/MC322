package com.rpglab.dungeonadventure.characters.monsters;

import com.rpglab.dungeonadventure.battle.moves.PetrifyingGaze;
import com.rpglab.dungeonadventure.battle.moves.TailSwipe;
import com.rpglab.dungeonadventure.characters.Monster;
import com.rpglab.dungeonadventure.items.Weapon;

public class Cockatrice extends Monster {

    public Cockatrice(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new PetrifyingGaze());
        addAction(new TailSwipe());
    }
}
