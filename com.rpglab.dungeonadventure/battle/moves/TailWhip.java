package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class TailWhip implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 20; // Tail whip damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used tail whip on " + target.getName() + " dealing " + damage + " damage!");
    }
}
