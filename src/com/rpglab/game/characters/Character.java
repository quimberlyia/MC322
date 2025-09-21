package com.rpglab.game.characters;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;
import com.rpglab.game.items.Weapon;
import com.rpglab.game.utils.GameDisplay;

/**
 * Abstract base class for all characters in the Dungeon Adventure RPG.
 * This class provides common functionality for both heroes and monsters,
 * including health management, strength attributes, weapon handling, and combat capabilities.
 * 
 * <p>All characters have basic attributes like name, health points, and strength.
 * They can equip weapons, take damage, heal, and participate in combat through
 * the Combatente interface implementation.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public abstract class Character implements Combatente {

    /** The character's name */
    private String name;
    
    /** The character's current health points */
    private int healthPoints;
    
    /** The character's strength value, affecting combat effectiveness */
    private int strength;
    
    /** The weapon currently equipped by this character */
    private Weapon weapon;    

    /**
     * Constructs a new Character with the specified attributes.
     * 
     * @param name The character's name
     * @param healthPoints The character's initial health points
     * @param strength The character's strength value
     */
    public Character(String name, int healthPoints, int strength) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
    }

    /**
     * Returns the character's name.
     * 
     * @return The character's name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the character's current strength value.
     * 
     * @return The strength value as an integer
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Increases the character's strength by the specified amount.
     * This method is typically used for character progression and stat bonuses.
     * 
     * @param increment The amount to add to the character's strength
     */
    public void addStrength(int increment) {
        this.strength += increment;
    }

    /**
     * Returns the character's current health points.
     * 
     * @return The current health points as an integer
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Modifies the character's health by the specified amount.
     * Positive values heal the character, negative values cause damage.
     * Health cannot go below zero.
     * 
     * @param damage The health change amount (negative for damage, positive for healing)
     */
    private void changeHealth(int damage) {
        this.healthPoints += damage;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    /**
     * Returns the weapon currently equipped by this character.
     * 
     * @return The equipped Weapon, or null if no weapon is equipped
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Equips the specified weapon to this character.
     * 
     * @param weapon The Weapon to equip, or null to unequip current weapon
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Applies damage to this character, reducing their health points.
     * This implementation of the Combatente interface uses the internal
     * changeHealth method to handle damage application.
     * 
     * @param damage The amount of damage to inflict (must be non-negative)
     */
    @Override
    public void takeDamage(int damage) {
        changeHealth(-damage);
    }

    /**
     * Restores health points to this character.
     * This implementation of the Combatente interface uses the internal
     * changeHealth method to handle healing.
     * 
     * @param amount The amount of health to restore (must be non-negative)
     */
    @Override
    public void heal(int amount) {
        changeHealth(amount);
    }

    /**
     * Checks if this character is still alive.
     * A character is considered alive if they have more than zero health points.
     * 
     * @return true if the character is alive, false if dead
     */
    @Override
    public boolean isAlive() {
        return healthPoints > 0;
    }

    /**
     * Abstract method for choosing a combat action.
     * Subclasses must implement this method to define their combat behavior,
     * whether through AI logic, player input, or other decision mechanisms.
     * 
     * @param target The target combatant for the action
     * @return A CombatAction representing the chosen action
     */
    public abstract CombatAction chooseAction(Combatente target);

    /**
     * Displays the character's current status including name, health, and strength.
     * Uses colored console output to provide a visually appealing status display.
     */
    public void showStatus() {
        String healthBar = "[" + healthPoints + " HP]";
        String strengthBar = "[" + strength + " Strength Points]";
        System.out.println("  " + GameDisplay.CYAN + name + GameDisplay.RESET + " " + healthBar + 
                          " | " + GameDisplay.YELLOW + strengthBar + GameDisplay.RESET);
    }
}

