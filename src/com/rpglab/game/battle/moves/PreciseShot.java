package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

public class PreciseShot implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = (user.getStrength() * 3) / 2;
        target.takeDamage(damage);
        System.out.println("The hero " + user.getName() + " used a precise shot on " + target.getName() + " for " + damage + " damage!");
    }
}
