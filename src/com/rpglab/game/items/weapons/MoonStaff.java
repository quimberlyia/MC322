package com.rpglab.game.items.weapons;

import com.rpglab.game.items.Weapon;

/**
 * The most powerful staff weapon for Mage heroes.
 * The Moon Staff is imbued with lunar magic, providing exceptional
 * magical channeling power. This rare and powerful staff represents
 * the pinnacle of magical weaponry for spellcasters.
 * 
 * <p>This weapon requires level 3 to equip and deals 20 damage,
 * making it the ultimate weapon for mage characters.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class MoonStaff extends Weapon {
    /**
     * Constructs a new Moon Staff with maximum magical attributes.
     * Sets damage to 20, minimum level to 3, and name to "Moon Staff".
     */
    public MoonStaff() {
        super(20, 3, "Moon Staff");
    }

    @Override
    public WeaponCategory getCategory() {
        return WeaponCategory.STAFF;
    }
}