package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class RustySword implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 12; // Rusty sword damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used rusty sword on " + target.getName() + " dealing " + damage + " damage!");
    }
}
