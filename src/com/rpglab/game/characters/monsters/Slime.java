package com.rpglab.game.characters.monsters;

import com.rpglab.game.characters.Monster;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.enums.WeaponType;

/**
 * Represents a Slime monster in the Dungeon Adventure RPG.
 * Slimes are gelatinous creatures that serve as common low-level enemies
 * in the dungeon entrance. They use acidic and engulfing attacks to
 * combat heroes.
 * 
 * <p>Slimes are equipped with two combat actions:</p>
 * <ul>
 *   <li>Acid Spit - A corrosive ranged attack</li>
 *   <li>Swallow - An engulfing attack that scales with the slime's health</li>
 * </ul>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Slime extends Monster {

    /**
     * Constructs a new Slime monster with the specified attributes.
     * Automatically equips the slime with Acid Spit and Swallow combat actions.
     * 
     * @param healthPoints The slime's initial health points
     * @param strength The slime's strength value
     * @param experience The experience points awarded when this slime is defeated
     * @param lootTable Array of weapon types this slime can drop as loot (shared via aggregation)
     * @param moves List of shared instances of combat action
     */
    public Slime(int healthPoints, int strength, int experience, WeaponType[] lootTable, CombatAction[] moves) {
        super("Slime", healthPoints, strength, experience, lootTable, moves);
    }
}
