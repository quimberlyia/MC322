package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class AcidSpit implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 15; // Fixed acid damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used acid spit on " + target.getName() + " dealing " + damage + " damage!");
    }
}
