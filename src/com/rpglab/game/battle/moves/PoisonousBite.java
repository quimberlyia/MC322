package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

public class PoisonousBite implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 22; // Poisonous bite damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used poisonous bite on " + target.getName() + " dealing " + damage + " damage!");
    }
}
