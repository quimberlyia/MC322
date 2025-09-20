package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class Tackle implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 10; // Basic tackle damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used tackle on " + target.getName() + " dealing " + damage + " damage!");
    }
}
