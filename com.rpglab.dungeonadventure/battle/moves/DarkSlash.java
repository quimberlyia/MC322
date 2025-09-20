package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class DarkSlash implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 45; // Powerful dark sword attack
        target.takeDamage(damage);
        System.out.println(user.getName() + " slashed dark enchanted sword on " + target.getName() + " dealing " + damage + " damage!");
    }
}
