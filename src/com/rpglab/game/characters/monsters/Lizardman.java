package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.ClawSwipe;
import com.rpglab.game.battle.moves.PoisonousBite;
import com.rpglab.game.battle.moves.TailWhip;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

public class Lizardman extends Monster {

    public Lizardman(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new PoisonousBite());
        addAction(new ClawSwipe());
        addAction(new TailWhip());
    }
}
