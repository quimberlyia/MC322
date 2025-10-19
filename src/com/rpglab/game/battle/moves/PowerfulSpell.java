package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatant;

/**
 * A devastating magical attack combat action primarily used by Mage heroes.
 * This spell delivers enhanced magical damage by channeling arcane energy
 * through the user's equipped weapon, making it significantly more effective
 * than standard attacks.
 * 
 * <p>The powerful spell calculates damage using the formula:
 * (user's strength × 3 + weapon damage) ÷ 2.
 * This formula combines the user's magical prowess with their staff's
 * power to create a devastating spell attack.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class PowerfulSpell implements CombatAction {
    
    /**
     * Executes a powerful magical spell against the target.
     * Calculates damage using the formula: (strength × 3 + weapon damage) ÷ 2.
     * This combines the hero's magical strength with their equipped weapon's
     * power to deliver a concentrated magical attack.
     * 
     * @param hero The combatant casting the powerful spell (typically a Mage)
     * @param monster The combatant receiving the magical attack
     */
    public void execute(Combatant hero, Combatant monster) {
        int damage = (hero.getStrength() * 3 + hero.getWeapon().getDamage()) / 2;
        monster.takeDamage(damage);
        System.out.println("The hero " + hero.getName() + " casts a powerful spell on " + monster.getName() + " with " + hero.getWeapon().getName() + " dealing " + damage + " damage!");
    }
}
