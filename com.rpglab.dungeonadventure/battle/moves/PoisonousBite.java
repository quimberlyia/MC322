package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class PoisonousBite implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 22; // Poisonous bite damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used poisonous bite on " + target.getName() + " dealing " + damage + " damage!");
    }
}
