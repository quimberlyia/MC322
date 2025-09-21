package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A basic sword attack using a weathered, rusty blade.
 * This combat action represents a fundamental melee weapon attack
 * with reduced effectiveness due to the weapon's deteriorated condition.
 * 
 * <p>This move is typically used by low-level monsters such as skeletons
 * who wield ancient, corroded weapons that have lost their original
 * sharpness and effectiveness over time.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class RustySword implements CombatAction {
    
    /**
     * Executes the rusty sword attack on the specified target.
     * The attack deals 12 points of slashing damage, representing
     * a basic sword strike with reduced effectiveness due to the
     * weapon's deteriorated and corroded condition.
     * 
     * @param user   the combatant wielding the rusty sword (typically undead)
     * @param target the combatant receiving the slashing damage
     */
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 12; // Rusty sword damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used rusty sword on " + target.getName() + " dealing " + damage + " damage!");
    }
}
