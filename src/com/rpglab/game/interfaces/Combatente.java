package com.rpglab.game.interfaces;
import com.rpglab.game.items.Weapon;

/**
 * Represents any entity that can participate in combat within the Dungeon Adventure RPG.
 * This interface defines the core capabilities required for combat participants,
 * including health management, damage dealing, and action selection.
 * 
 * <p>Classes implementing this interface can engage in battles, take damage,
 * heal, and choose combat actions. This includes both heroes and monsters.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public interface Combatente {
    
    /**
     * Returns the name of this combatant.
     * 
     * @return The name of the combatant as a String
     */
    String getName();
    
    /**
     * Checks if this combatant is still alive (has positive health points).
     * 
     * @return true if the combatant is alive, false if dead
     */
    boolean isAlive();
    
    /**
     * Returns the current health points of this combatant.
     * 
     * @return The current health points as an integer
     */
    int getHealthPoints();
    
    /**
     * Applies damage to this combatant, reducing their health points.
     * 
     * @param damage The amount of damage to inflict (must be non-negative)
     */
    void takeDamage(int damage);
    
    /**
     * Restores health points to this combatant.
     * 
     * @param amount The amount of health to restore (must be non-negative)
     */
    void heal(int amount);
    
    /**
     * Selects and returns a combat action for this combatant to perform.
     * The choice may be based on AI logic for monsters or player input for heroes.
     * 
     * @param target The target combatant for the action
     * @return A CombatAction representing the chosen action
     */
    CombatAction chooseAction(Combatente target);
    
    /**
     * Returns the strength value of this combatant.
     * Strength typically affects damage calculations and combat effectiveness.
     * 
     * @return The strength value as an integer
     */
    int getStrength();
    Weapon getWeapon();
}
