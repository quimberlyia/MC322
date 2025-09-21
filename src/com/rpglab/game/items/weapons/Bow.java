package com.rpglab.game.items.weapons;

import com.rpglab.game.items.Weapon;

/**
 * A basic bow weapon designed for Archer heroes.
 * This ranged weapon provides moderate damage and is available from level 1,
 * making it an ideal starting weapon for archer characters.
 * 
 * <p>The bow is the default weapon for archers and provides a balanced
 * combination of damage and accessibility for early-game combat.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Bow extends Weapon {
    
    /**
     * Constructs a new Bow with standard attributes.
     * Sets damage to 5, minimum level to 1, and name to "Bow".
     */
    public Bow() {
        super(5, 1, "Bow");
    }
}