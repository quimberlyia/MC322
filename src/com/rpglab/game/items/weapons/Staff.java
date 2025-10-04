package com.rpglab.game.items.weapons;

import com.rpglab.game.items.Weapon;

/**
 * A magical staff weapon designed for Mage heroes.
 * This weapon provides higher damage than basic weapons and is specifically
 * designed to channel magical energy for spellcasting characters.
 * 
 * <p>The staff is the default weapon for mages and offers superior damage
 * output compared to other starting weapons, reflecting the magical nature
 * of mage combat abilities.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Staff extends Weapon {
    
    /**
     * Constructs a new Staff with standard attributes.
     * Sets damage to 10, minimum level to 1, and name to "Staff".
     */
    public Staff() {
        super(10, 1, "Staff");
    }

    @Override
    public WeaponCategory getCategory() {
        return WeaponCategory.STAFF;
    }
}