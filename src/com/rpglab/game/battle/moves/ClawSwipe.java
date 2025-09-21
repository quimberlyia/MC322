package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

public class ClawSwipe implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 18; // Claw swipe damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used claw swipe on " + target.getName() + " dealing " + damage + " damage!");
    }
}
