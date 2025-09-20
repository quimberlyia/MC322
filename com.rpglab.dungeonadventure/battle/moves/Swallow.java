package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class Swallow implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = user.getHealthPoints() / 10; // Damage based on user's health
        target.takeDamage(damage);
        System.out.println(user.getName() + " swallows " + target.getName() + " dealing " + damage + " damage!");
    }
}
