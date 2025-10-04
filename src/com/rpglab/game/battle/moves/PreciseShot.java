package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A precise ranged attack combat action primarily used by Archer heroes.
 * This attack delivers enhanced damage by focusing on accuracy and precision,
 * making it more effective than standard attacks.
 * 
 * <p>The precise shot calculates damage based on the user's strength with
 * a 1.5x multiplier, representing the focused nature of the attack.
 * This makes it particularly effective for archer characters who specialize
 * in ranged combat.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class PreciseShot implements CombatAction {
    
    /**
     * Executes a precise shot attack against the target.
     * Calculates damage as 1.5 times the user's strength value,
     * representing the enhanced effectiveness of a well-aimed attack.
     * 
     * @param user The combatant performing the precise shot
     * @param target The combatant receiving the attack
     */
    public void execute(Combatente hero, Combatente target) {
        int damage = (hero.getStrength() * 3 + hero.getWeapon().getDamage()) / 2;
        target.takeDamage(damage);
        System.out.println("The hero " + hero.getName() + " used a precise shot with " + hero.getWeapon().getName() + " on " + target.getName() + " for " + damage + " damage!");
    }
}
