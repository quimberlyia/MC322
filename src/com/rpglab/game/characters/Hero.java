package com.rpglab.game.characters;

import java.util.List;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;
import com.rpglab.game.items.Weapon;
import com.rpglab.game.utils.GameDisplay;

import java.util.ArrayList;

/**
 * Abstract base class for all hero characters in the Dungeon Adventure RPG.
 * Heroes are player-controlled characters that can level up, gain experience,
 * and have special abilities. They extend the basic Character functionality
 * with progression systems and luck mechanics.
 * 
 * <p>Heroes have additional attributes like level, experience points, and luck values
 * that affect their performance in combat and interactions. They can equip weapons
 * with level restrictions and use special skills unique to their class.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public abstract class Hero extends Character {

    /** The hero's current level, starting at 1 */
    private int level = 1;
    
    /** The hero's current experience points, needed for leveling up */
    private int experience = 0;
    
    /** The hero's luck value, affecting various random outcomes */
    private double lucky = 0;

    /** List of available combat actions for this hero */
    protected List<CombatAction> action = new ArrayList<>();

    /**
     * Abstract method for choosing a combat action.
     * Each hero class must implement their own action selection logic.
     * 
     * @param target The target combatant for the action
     * @return A CombatAction representing the chosen action
     */
    @Override
    public abstract CombatAction chooseAction(Combatente target);

    /**
     * Constructs a new Hero with the specified attributes.
     * 
     * @param name The hero's name
     * @param healthPoints The hero's initial health points
     * @param strength The hero's initial strength value
     * @param lucky The hero's initial luck value
     */
    public Hero(String name, int healthPoints, int strength, double lucky) {
        super(name, healthPoints, strength);
        this.lucky = lucky;
    }

    /**
     * Returns the hero's current luck value.
     * Luck affects various random outcomes in the game.
     * 
     * @return The luck value as a double
     */
    public double getLucky() {
        return lucky;
    }

    /**
     * Returns the hero's current level.
     * 
     * @return The current level as an integer
     */
    public int getLevel() {
        return level;
    }

    /**
     * Returns the hero's current experience points.
     * 
     * @return The current experience points as an integer
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Sets the hero's luck value to the specified amount.
     * 
     * @param lucky The new luck value
     */
    public void setLucky(double lucky) {
        this.lucky = lucky;
    }

    /**
     * Handles the level up process for the hero.
     * Increases level, improves stats, and displays level up notification.
     * Each level up grants: +0.1 luck, +3*level strength, +5*level health.
     */
    private void levelUp() {
        this.level++;
        this.lucky += 0.1;
        addStrength(level * 3);
        heal(level * 5);

        System.out.println();
        System.out.println(GameDisplay.YELLOW + GameDisplay.BOLD + "LEVEL UP!" + GameDisplay.RESET);
        System.out.println(GameDisplay.YELLOW + getName() + " has reached level " + level + "!" + GameDisplay.RESET);
        System.out.println();
    }

    /**
     * Awards experience points to the hero and handles automatic leveling.
     * Heroes level up automatically when they reach 100 experience points.
     * Excess experience carries over to the next level.
     * 
     * @param exp The amount of experience points to award
     */
    public void gainExperience(int exp) {
        this.experience += exp;
        while (this.experience >= 100)
        {
            levelUp();
            this.experience -= 100;
        }
    }

    /**
     * Abstract method for using the hero's special skill.
     * Each hero class must implement their unique special ability.
     * 
     * @param target The target character for the special skill
     */
    public abstract void useSpecialSkill(Character target);

    /**
     * Adds a combat action to the hero's available actions list.
     * 
     * @param combatAction The CombatAction to add to the hero's repertoire
     */
    public void addAction(CombatAction combatAction) {
        action.add(combatAction);
    }

    /**
     * Returns the list of available combat actions for this hero.
     * 
     * @return A List of CombatAction objects available to this hero
     */
    public List<CombatAction> getActions() {
        return action;
    }

    /**
     * Displays the hero's detailed status including level, experience, and equipment.
     * Provides an enhanced status display compared to the base Character class,
     * showing hero-specific information like level, experience progress, and equipped weapon.
     */
    @Override
    public void showStatus() {
        String healthBar = "[" + getHealthPoints() + " HP]";
        String strengthBar = "[" + getStrength() + " Strength Points]";
        System.out.println("  " + GameDisplay.BOLD + GameDisplay.BLUE + getName() + GameDisplay.RESET + " Lv." + level);
        System.out.println("    " + healthBar + 
                          " | " + GameDisplay.YELLOW + strengthBar + GameDisplay.RESET +
                          " | " + GameDisplay.PURPLE + "EXP: " + experience + "/100" + GameDisplay.RESET);
        if (getWeapon() != null) {
            System.out.println("    " + GameDisplay.CYAN + getWeapon().getName() + 
                              " (+" + getWeapon().getDamage() + " DMG)" + GameDisplay.RESET);
        }
        System.out.println();
    }

    /**
     * Attempts to equip a weapon to the hero.
     * Checks level requirements before allowing the weapon to be equipped.
     * Displays appropriate messages for successful or failed equipment attempts.
     * 
     * @param weapon The Weapon to attempt to equip
     */
    public void equipWeapon(Weapon weapon) {

        if (weapon.getMinLevel() > this.level) {
            System.out.println(GameDisplay.YELLOW + getName() + " cannot equip " + weapon.getName() + " (requires level " + weapon.getMinLevel() + ")" + GameDisplay.RESET);
            return;
        }

        setWeapon(weapon);
        System.out.println(GameDisplay.CYAN + getName() + " equipped " + weapon.getName() + "!" + GameDisplay.RESET);
    }
}