package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A corrosive acid spit attack used by slime-type monsters.
 * This combat action inflicts moderate chemical damage on the target,
 * simulating an acidic projectile attack.
 * 
 * <p>This move is typically used by weaker monsters as a ranged attack
 * that can bypass some defensive measures due to its corrosive nature.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class AcidSpit implements CombatAction {
    
    /**
     * Executes the acid spit attack on the specified target.
     * The attack deals 15 points of chemical damage, representing
     * the corrosive nature of the acidic projectile.
     * 
     * @param user   the combatant performing the acid spit attack
     * @param target the combatant receiving the acid damage
     */
    public void execute(Combatente user, Combatente target) {
        int damage = 15; // Fixed acid damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used acid spit on " + target.getName() + " dealing " + damage + " damage!");
    }
}
