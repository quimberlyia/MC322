package com.rpglab.dungeonadventure.battle.moves;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;

public class PowerfulSpell implements CombatAction {
    
    @Override
    public void execute(Combatente hero, Combatente monster) {
        int damage = (hero.getStrength() * 3) / 2;
        monster.takeDamage(damage);
        System.out.println("The hero " + hero.getName() + " casts a powerful spell on " + monster.getName() + " dealing " + damage + " damage!");
    }
}
