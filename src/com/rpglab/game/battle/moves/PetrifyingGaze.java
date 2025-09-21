package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

public class PetrifyingGaze implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 30; // Petrifying damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used petrifying gaze on " + target.getName() + " dealing " + damage + " damage!");
    }
}
