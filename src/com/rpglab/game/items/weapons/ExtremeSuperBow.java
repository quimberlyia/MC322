package com.rpglab.game.items.weapons;

import com.rpglab.game.items.Weapon;

/**
 * The most powerful bow weapon for Archer heroes.
 * The Extreme Super Bow represents the pinnacle of archery weaponry,
 * dealing the highest damage among all bow weapons. This rare weapon
 * can only be wielded by experienced archers.
 * 
 * <p>This weapon requires level 3 to equip and deals 30 damage,
 * making it the ultimate ranged weapon for archer characters.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class ExtremeSuperBow extends Weapon {
    /**
     * Constructs a new Extreme Super Bow with maximum attributes.
     * Sets damage to 30, minimum level to 3, and name to "Extreme Super Bow".
     */
    public ExtremeSuperBow() {
        super(30, 3, "Extreme Super Bow");
    }

    @Override
    public WeaponCategory getCategory() {
        return WeaponCategory.BOW;
    }
}