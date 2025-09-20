package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class ClawSwipe implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 18; // Claw swipe damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used claw swipe on " + target.getName() + " dealing " + damage + " damage!");
    }
}
