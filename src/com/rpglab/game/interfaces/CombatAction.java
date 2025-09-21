package com.rpglab.game.interfaces;

/**
 * Represents an action that can be performed during combat.
 * This interface defines the contract for all combat actions including attacks,
 * spells, healing potions, and other battlefield abilities.
 * 
 * <p>Combat actions are executed between two combatants - a user who performs
 * the action and a target who receives its effects. The action's implementation
 * determines what happens when it is executed.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public interface CombatAction {
    
    /**
     * Executes this combat action between the specified user and target.
     * The specific behavior depends on the implementation of the action.
     * 
     * <p>Examples of execution effects include:</p>
     * <ul>
     *   <li>Dealing damage to the target</li>
     *   <li>Healing the user or target</li>
     *   <li>Applying status effects</li>
     *   <li>Modifying combat statistics</li>
     * </ul>
     * 
     * @param user The combatant performing this action
     * @param target The combatant who is the target of this action
     */
    void execute(Combatente user, Combatente target);
}
