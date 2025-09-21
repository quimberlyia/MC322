package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A powerful dark-enchanted sword attack used by high-level evil creatures.
 * This combat action channels dark magic through a blade to deliver
 * devastating damage to the target with unholy power.
 * 
 * <p>This move is typically reserved for boss-level monsters such as
 * the Demon King, representing one of the most dangerous sword-based
 * attacks in the dungeon.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class DarkSlash implements CombatAction {
    
    /**
     * Executes the dark slash attack on the specified target.
     * The attack deals 45 points of dark-enchanted damage, representing
     * one of the most powerful sword-based attacks infused with evil magic.
     * 
     * @param user   the combatant performing the dark slash attack (typically boss monsters)
     * @param target the combatant receiving the dark-enchanted damage
     */
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 45; // Powerful dark sword attack
        target.takeDamage(damage);
        System.out.println(user.getName() + " slashed dark enchanted sword on " + target.getName() + " dealing " + damage + " damage!");
    }
}
