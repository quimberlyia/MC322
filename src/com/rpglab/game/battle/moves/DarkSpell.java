package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

public class DarkSpell implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 40; // Powerful dark magic damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " cast a powerful dark spell on " + target.getName() + " dealing " + damage + " damage!");
    }
}
