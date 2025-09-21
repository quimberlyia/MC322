package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A venomous bite attack used by creatures with toxic fangs.
 * This combat action delivers both physical damage from the bite
 * and additional harm from the injected venom or poison.
 * 
 * <p>This move is commonly used by serpentine creatures, undead,
 * and other monsters that have developed venomous bite capabilities
 * as a natural weapon.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class PoisonousBite implements CombatAction {
    
    /**
     * Executes the poisonous bite attack on the specified target.
     * The attack deals 22 points of toxic damage, representing
     * both the physical trauma of the bite and the harmful effects
     * of injected venom.
     * 
     * @param user   the combatant performing the poisonous bite
     * @param target the combatant receiving the toxic damage
     */
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 22; // Poisonous bite damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used poisonous bite on " + target.getName() + " dealing " + damage + " damage!");
    }
}
