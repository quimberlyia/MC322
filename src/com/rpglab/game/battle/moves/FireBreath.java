package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

public class FireBreath implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 35; // Powerful fire breath damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " breathed fire on " + target.getName() + " dealing " + damage + " damage!");
    }
}
