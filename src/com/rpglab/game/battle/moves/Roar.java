package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

public class Roar implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 25; // Intimidating roar damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used roar on " + target.getName() + " dealing " + damage + " damage!");
    }
}
