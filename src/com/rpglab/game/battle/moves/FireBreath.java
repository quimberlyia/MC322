package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A devastating fire-breathing attack used by dragon-type monsters.
 * This combat action unleashes a torrent of flames that engulfs the target,
 * dealing significant fire damage through intense heat and combustion.
 * 
 * <p>This move is a signature attack of dragons and other fire-breathing
 * creatures, representing one of the most iconic and dangerous elemental
 * attacks in the dungeon.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class FireBreath implements CombatAction {
    
    /**
     * Executes the fire breath attack on the specified target.
     * The attack deals 35 points of fire damage, representing
     * the intense heat and flames of a dragon's breath weapon.
     * 
     * @param user   the combatant breathing fire (typically dragons)
     * @param target the combatant receiving the fire damage
     */
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 35; // Powerful fire breath damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " breathed fire on " + target.getName() + " dealing " + damage + " damage!");
    }
}
