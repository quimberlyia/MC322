package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A supernatural gaze attack that inflicts petrification damage.
 * This combat action uses magical sight to inflict harm through
 * mystical petrifying energies that partially turn flesh to stone.
 * 
 * <p>This move is typically used by mythical creatures like cockatrices
 * and other monsters with supernatural eye-based abilities that can
 * bypass conventional defenses through magical sight.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class PetrifyingGaze implements CombatAction {
    
    /**
     * Executes the petrifying gaze attack on the specified target.
     * The attack deals 30 points of magical damage, representing
     * the supernatural power of a petrifying stare that partially
     * turns the target's flesh to stone.
     * 
     * @param user   the combatant using petrifying gaze (typically cockatrices)
     * @param target the combatant receiving the petrification damage
     */
    public void execute(Combatente user, Combatente target) {
        int damage = 30; // Petrifying damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used petrifying gaze on " + target.getName() + " dealing " + damage + " damage!");
    }
}
