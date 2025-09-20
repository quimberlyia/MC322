package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class PetrifyingGaze implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 30; // Petrifying damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used petrifying gaze on " + target.getName() + " dealing " + damage + " damage!");
    }
}
