package com.rpglab.game.characters.monsters;

import com.rpglab.game.characters.Monster;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.enums.WeaponType;

/**
 * Represents a Cockatrice monster in the Dungeon Adventure RPG.
 * Cockatrices are mythical creatures with supernatural abilities encountered
 * in the Dark Hallway. They combine physical tail attacks with their infamous
 * petrifying gaze, making them dangerous mid-game opponents.
 * 
 * <p>Cockatrices are equipped with two combat actions:</p>
 * <ul>
 *   <li>Petrifying Gaze - A supernatural eye-based attack that inflicts magical damage</li>
 *   <li>Tail Swipe - A powerful sweeping tail attack dealing bludgeoning damage</li>
 * </ul>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Cockatrice extends Monster {

    /**
     * Constructs a new Cockatrice monster with the specified attributes.
     * Automatically equips the cockatrice with Petrifying Gaze and Tail Swipe
     * combat actions.
     * 
     * @param healthPoints The cockatrice's initial health points
     * @param strength The cockatrice's strength value
     * @param experience The experience points awarded when this cockatrice is defeated
     * @param lootTable Array of weapon types this cockatrice can drop as loot (shared via aggregation)
     * @param moves List of shared instances of combat action
     */
    public Cockatrice(int healthPoints, int strength, int experience, WeaponType[] lootTable, CombatAction[] moves) {
        super("Cockatrice", healthPoints, strength, experience, lootTable, moves);
    }
}
