package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatant;

/**
 * A healing combat action that restores health points to the user.
 * This consumable action allows characters to recover health during battle,
 * providing essential sustainability for prolonged combat encounters.
 * 
 * <p>The healing potion is a self-targeting action that restores a fixed
 * amount of health regardless of the character's stats. It's available to
 * both archer and mage hero classes as a fundamental survival tool.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class HealingPotion implements CombatAction {
    
    /**
     * Executes the healing potion action, restoring health to the user.
     * The action ignores the target parameter and always heals the user
     * for a fixed amount of 30 health points.
     * 
     * @param user The combatant who drinks the healing potion
     * @param target The target parameter (ignored for this self-healing action)
     */
    public void execute(Combatant user, Combatant target) {
        int healAmount = 30;
        user.heal(healAmount);
        System.out.println(user.getName() + " drinks a healing potion and recovers " + healAmount + " health points!");
    }
}
