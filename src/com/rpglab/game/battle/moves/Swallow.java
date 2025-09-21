package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

public class Swallow implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = user.getHealthPoints() / 10; // Damage based on user's health
        target.takeDamage(damage);
        System.out.println(user.getName() + " swallows " + target.getName() + " dealing " + damage + " damage!");
    }
}
