package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A precise ranged attack combat action primarily used by Archer heroes.
 * This attack delivers enhanced damage by focusing on accuracy and precision,
 * combining the archer's skill with their weapon's power for maximum effect.
 * 
 * <p>The precise shot calculates damage using the formula:
 * (user's strength × 3 + weapon damage) ÷ 2.
 * This formula represents the focused aim and technique that archers use
 * to maximize their weapon's effectiveness in ranged combat.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class PreciseShot implements CombatAction {
    
    /**
     * Executes a precise shot attack against the target.
     * Calculates damage using the formula: (strength × 3 + weapon damage) ÷ 2.
     * This combines the hero's physical strength and aim with their equipped
     * bow's power to deliver a devastating ranged attack.
     * 
     * @param hero The combatant performing the precise shot (typically an Archer)
     * @param target The combatant receiving the attack
     */
    public void execute(Combatente hero, Combatente target) {
        int damage = (hero.getStrength() * 3 + hero.getWeapon().getDamage()) / 2;
        target.takeDamage(damage);
        System.out.println("The hero " + hero.getName() + " used a precise shot with " + hero.getWeapon().getName() + " on " + target.getName() + " for " + damage + " damage!");
    }
}
