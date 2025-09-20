package com.rpglab.dungeonadventure.characters.monsters;

import com.rpglab.dungeonadventure.battle.moves.ClawSwipe;
import com.rpglab.dungeonadventure.battle.moves.PoisonousBite;
import com.rpglab.dungeonadventure.battle.moves.TailWhip;
import com.rpglab.dungeonadventure.characters.Monster;
import com.rpglab.dungeonadventure.items.Weapon;

public class Lizardman extends Monster {

    public Lizardman(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new PoisonousBite());
        addAction(new ClawSwipe());
        addAction(new TailWhip());
    }
}
