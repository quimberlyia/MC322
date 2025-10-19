package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatant;

/**
 * A swift claw-based melee attack used by beast-type monsters.
 * This combat action delivers a quick slashing attack with natural claws,
 * dealing moderate physical damage to the target.
 * 
 * <p>This move is commonly used by monsters with natural claw weapons
 * such as lizardmen, dragons, and other beast-type creatures.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class ClawSwipe implements CombatAction {
    
    /**
     * Executes the claw swipe attack on the specified target.
     * The attack deals 18 points of slashing damage, representing
     * a swift and precise strike with natural claws.
     * 
     * @param user   the combatant performing the claw swipe attack
     * @param target the combatant receiving the slashing damage
     */
    public void execute(Combatant user, Combatant target) {
        int damage = 18; // Claw swipe damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used claw swipe on " + target.getName() + " dealing " + damage + " damage!");
    }
}
