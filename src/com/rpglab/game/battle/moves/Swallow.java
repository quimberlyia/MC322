package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A consumption-based attack that engulfs or partially swallows the target.
 * This combat action deals damage proportional to the user's current health,
 * representing a desperate or powerful engulfing attack.
 * 
 * <p>This move is typically used by large monsters such as slimes or
 * other creatures capable of engulfing their prey. The damage scales
 * with the attacker's vitality, making healthier monsters more dangerous.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Swallow implements CombatAction {
    
    /**
     * Executes the swallow attack on the specified target.
     * The damage dealt is calculated as 10% of the user's current health points,
     * representing an engulfing attack whose power scales with the attacker's vitality.
     * This makes healthier monsters more dangerous when using this ability.
     * 
     * @param user   the combatant performing the swallow attack
     * @param target the combatant being engulfed and damaged
     */
    public void execute(Combatente user, Combatente target) {
        int damage = user.getHealthPoints() / 10; // Damage based on user's health
        target.takeDamage(damage);
        System.out.println(user.getName() + " swallows " + target.getName() + " dealing " + damage + " damage!");
    }
}
