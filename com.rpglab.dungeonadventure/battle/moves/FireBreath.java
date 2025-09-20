package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class FireBreath implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 35; // Powerful fire breath damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " breathed fire on " + target.getName() + " dealing " + damage + " damage!");
    }
}
