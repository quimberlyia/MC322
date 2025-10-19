package com.rpglab.game.characters;

import java.util.List;
import java.util.Random;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatant;
import com.rpglab.game.interfaces.Item;
import com.rpglab.game.interfaces.Lootable;
import com.rpglab.game.enums.WeaponType;
import com.rpglab.game.utils.GameDisplay;

import java.util.ArrayList;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 * Represents a monster character in the Dungeon Adventure RPG.
 * Monsters are AI-controlled enemies that heroes fight against in combat.
 * They extend the Character class and implement the Lootable interface,
 * allowing them to drop items when defeated.
 * 
 * <p>Monsters have unique characteristics compared to heroes: they cannot heal
 * themselves, choose actions randomly from their available set, and provide
 * experience points when defeated. They also carry loot that can be dropped
 * for victorious heroes.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD) // Field access for JAXB

public class Monster extends Character implements Lootable  {

    /** The experience points awarded to heroes when this monster is defeated */
    private int experience;
    
    /** 
     * Array of weapon types that this monster can drop as loot.
     * Uses shared aggregation - multiple monsters can reference the same loot table array.
     * Weapons are only instantiated when actually dropped.
     */
        /** Array of weapons that this monster can drop as loot */
    @XmlElementWrapper(name = "lootTable")
    @XmlElement(name = "lootTable")
    private WeaponType[] lootTable;
    
    /** List of combat actions available to this monster */
    @XmlTransient
    protected List<CombatAction> actions = new ArrayList<>();

    // This constructor is required for JAXB to instantiate the class during XML deserialization
    public Monster() {
    }

    /**
     * Overrides the heal method to prevent monsters from healing.
     * Monsters in this game system cannot restore their health once damaged.
     * 
     * @param amount The healing amount (ignored for monsters)
     */
    public void heal(int amount) {
        return ;
    }

    /**
     * Chooses a random combat action from the monster's available actions.
     * This provides unpredictable AI behavior by randomly selecting from
     * the monster's action repertoire.
     * 
     * @param target The target combatant for the action
     * @return A randomly selected CombatAction, or null if no actions are available
     */
    public CombatAction chooseAction(Combatant target) {
        if (actions.isEmpty()) return null;
        Random rand = new Random();
        int idx = rand.nextInt(actions.size());
        return actions.get(idx);
    }

    /**
     * Constructs a new Monster with the specified attributes and loot table.
     * 
     * <p>This constructor uses shared aggregation for loot tables. The lootTable array
     * can be shared between multiple monster instances, and weapons are only instantiated
     * when actually dropped.</p>
     * 
     * @param name The monster's name
     * @param healthPoints The monster's health points
     * @param strength The monster's strength value
     * @param experience The experience points awarded when this monster is defeated
     * @param lootTable Array of weapon types this monster can drop as loot (shared via aggregation)
     * @param moves Array of combat actions this monster can use (shared via aggregation)
     */
    public Monster(String name, int healthPoints, int strength, int experience, WeaponType[] lootTable, CombatAction[] moves) {
        super(name, healthPoints, strength);
        this.experience = experience;
        this.lootTable = lootTable;
        for (CombatAction move : moves) {
            addAction(move);
        }
    }

    /**
     * Returns the experience points awarded when this monster is defeated.
     * 
     * @return The experience point value as an integer
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Returns the array of weapon types this monster can drop as loot.
     * 
     * @return Array of WeaponType values representing potential loot drops
     */
    public WeaponType[] getLootTable() {
        return lootTable;
    }

    /**
     * Sets the loot table for this monster.
     * 
     * @param lootTable Array of weapon types to set as the monster's potential loot drops
     */
    public void setLootTable(WeaponType[] lootTable) {
        this.lootTable = lootTable;
    }

    /**
     * Randomly selects and returns a weapon from the monster's loot table.
     * Implementation of the Lootable interface that provides random loot
     * selection when the monster is defeated.
     * 
     * <p>This method instantiates a new weapon on-demand using the WeaponType
     * factory method, ensuring weapons only exist when actually dropped.</p>
     * 
     * @return A newly created Weapon instance, or null if loot table is empty
     */
    public Item dropLoot() {
        if (lootTable == null || lootTable.length == 0) {
            return null;
        }
        int index = (int) (Math.random() * lootTable.length);
        return lootTable[index].create();
    }

    /**
     * Returns the list of combat actions available to this monster.
     * 
     * @return List of CombatAction objects this monster can perform
     */
    public List<CombatAction> getActions() {
        return actions;
    }

    /**
     * Hook to initialize actions after deserialization. Subclasses override this
     * to re-add their default CombatAction implementations.
     */
    public void initActions() {
        // default no-op; subclasses should override
    }

    /**
     * Adds a combat action to this monster's available actions.
     * 
     * @param action The CombatAction to add to the monster's repertoire
     */
    public void addAction(CombatAction action) {
        actions.add(action);
    }

    /**
     * Displays the monster's status including health, strength, and experience value.
     * Provides a distinct visual presentation for monsters using red coloring
     * and showing the experience points they're worth when defeated.
     */
    public void showStatus() {
        String healthBar = "[" + getHealthPoints() + " HP]";
        String strengthBar = "[" + getStrength() + " Strength Points]";
        System.out.println("  " + GameDisplay.BOLD + GameDisplay.RED + getName() + GameDisplay.RESET);
        System.out.println("    " + healthBar + 
                          " | " + GameDisplay.YELLOW + strengthBar + GameDisplay.RESET +
                          " | " + GameDisplay.PURPLE + "Worth: " + experience + " EXP" + GameDisplay.RESET);
        System.out.println();
    }
}
