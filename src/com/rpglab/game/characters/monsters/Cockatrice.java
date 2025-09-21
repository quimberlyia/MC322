package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.PetrifyingGaze;
import com.rpglab.game.battle.moves.TailSwipe;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

public class Cockatrice extends Monster {

    public Cockatrice(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new PetrifyingGaze());
        addAction(new TailSwipe());
    }
}
