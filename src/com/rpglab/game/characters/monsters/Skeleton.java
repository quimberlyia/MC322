package com.rpglab.game.characters.monsters;

import com.rpglab.game.characters.Monster;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.enums.WeaponType;

/**
 * Represents a Skeleton monster in the Dungeon Adventure RPG.
 * Skeletons are undead warriors that inhabit the dungeon entrance,
 * wielding ancient corroded weapons. They serve as early-game enemies
 * with basic combat capabilities.
 * 
 * <p>Skeletons are equipped with two combat actions:</p>
 * <ul>
 *   <li>Rusty Sword - A basic melee attack with a deteriorated blade</li>
 *   <li>Tackle - A straightforward physical charging assault</li>
 * </ul>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Skeleton extends Monster {

    /**
     * Constructs a new Skeleton monster with the specified attributes.
     * Automatically equips the skeleton with Rusty Sword and Tackle combat actions.
     * 
     * @param healthPoints The skeleton's initial health points
     * @param strength The skeleton's strength value
     * @param experience The experience points awarded when this skeleton is defeated
     * @param lootTable Array of weapon types this skeleton can drop as loot (shared via aggregation)
     * @param moves List of shared instances of combat action
     */
    public Skeleton(int healthPoints, int strength, int experience, WeaponType[] lootTable, CombatAction[] moves) {
        super("Skeleton", healthPoints, strength, experience, lootTable, moves);
    }

        // This constructor is required for JAXB to instantiate the class during XML deserialization
        protected Skeleton() {
            super();
        }

        @Override
        public void initActions() {
            this.actions.clear();
            addAction(new RustySword());
            addAction(new Tackle());
        }
}
