package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A basic physical tackle attack used by various monsters.
 * This combat action represents a straightforward charging assault
 * using body weight and momentum to inflict blunt force damage.
 * 
 * <p>This move is one of the most fundamental physical attacks,
 * commonly used by creatures of all sizes as a basic form of
 * melee combat that requires no special abilities or weapons.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Tackle implements CombatAction {
    
    /**
     * Executes the tackle attack on the specified target.
     * The attack deals 10 points of blunt force damage, representing
     * a basic charging assault using body weight and momentum.
     * 
     * @param user   the combatant performing the tackle attack
     * @param target the combatant receiving the blunt force damage
     */
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 10; // Basic tackle damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used tackle on " + target.getName() + " dealing " + damage + " damage!");
    }
}
