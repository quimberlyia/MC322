package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatant;

/**
 * A quick, lashing tail attack used by agile reptilian creatures.
 * This combat action delivers a rapid whip-like strike using the tail
 * as a flexible weapon to inflict moderate damage with good accuracy.
 * 
 * <p>This move is typically used by smaller reptilian monsters or
 * creatures with more flexible tails, offering a balance between
 * speed and damage compared to the heavier tail swipe attack.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class TailWhip implements CombatAction {
    
    /**
     * Executes the tail whip attack on the specified target.
     * The attack deals 20 points of lashing damage, representing
     * a quick, precise strike using the tail as a flexible whip-like weapon.
     * 
     * @param user   the combatant performing the tail whip (typically agile reptiles)
     * @param target the combatant receiving the lashing damage
     */
    public void execute(Combatant user, Combatant target) {
        int damage = 20; // Tail whip damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used tail whip on " + target.getName() + " dealing " + damage + " damage!");
    }
}
