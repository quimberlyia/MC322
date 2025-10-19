package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.AcidSpit;
import com.rpglab.game.battle.moves.Swallow;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

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
     * @param name The slime's name
     * @param healthPoints The slime's initial health points
     * @param strength The slime's strength value
     * @param experience The experience points awarded when this slime is defeated
     * @param loot Array of weapons this slime can drop as loot
     */
    public Slime(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new AcidSpit());
        addAction(new Swallow());
    }

    @Override
    public void initActions() {
        this.actions.clear();
        addAction(new AcidSpit());
        addAction(new Swallow());
    }

    //// This constructor is required for JAXB to instantiate the class during XML deserialization
    protected Slime() {
        super();
    }
}
