package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

public class Tackle implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 10; // Basic tackle damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used tackle on " + target.getName() + " dealing " + damage + " damage!");
    }
}
