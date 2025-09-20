package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class DarkSpell implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 40; // Powerful dark magic damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " cast a powerful dark spell on " + target.getName() + " dealing " + damage + " damage!");
    }
}
