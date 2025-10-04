package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A powerful tail-based sweeping attack used by reptilian and draconic monsters.
 * This combat action utilizes a creature's tail as a weapon to deliver
 * a wide-area strike that can knock enemies off balance while dealing damage.
 * 
 * <p>This move is commonly used by dragons, lizardmen, and other creatures
 * with muscular tails, representing a signature attack that leverages
 * their natural anatomy as a weapon.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class TailSwipe implements CombatAction {
    
    /**
     * Executes the tail swipe attack on the specified target.
     * The attack deals 25 points of bludgeoning damage, representing
     * a powerful sweeping strike using a muscular tail as a natural weapon.
     * 
     * @param user   the combatant performing the tail swipe (typically reptilian creatures)
     * @param target the combatant receiving the bludgeoning damage
     */
    public void execute(Combatente user, Combatente target) {
        int damage = 25; // Tail swipe damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used tail swipe on " + target.getName() + " dealing " + damage + " damage!");
    }
}
