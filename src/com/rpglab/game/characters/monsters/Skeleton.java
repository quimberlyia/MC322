package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.RustySword;
import com.rpglab.game.battle.moves.Tackle;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

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
     * @param name The skeleton's name
     * @param healthPoints The skeleton's initial health points
     * @param strength The skeleton's strength value
     * @param experience The experience points awarded when this skeleton is defeated
     * @param loot Array of weapons this skeleton can drop as loot
     */
    public Skeleton(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new RustySword());
        addAction(new Tackle());
    }
}
