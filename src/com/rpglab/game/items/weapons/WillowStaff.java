package com.rpglab.game.items.weapons;

import com.rpglab.game.items.Weapon;

/**
 * An upgraded staff weapon for Mage heroes.
 * The Willow Staff is crafted from magical willow wood, providing
 * enhanced magical channeling capabilities compared to the basic Staff.
 * This mid-tier weapon is suitable for mages who have advanced in skill.
 * 
 * <p>This weapon requires level 2 to equip and deals 15 damage,
 * representing improved magical power for spellcasting.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class WillowStaff extends Weapon {
    /**
     * Constructs a new Willow Staff with enhanced attributes.
     * Sets damage to 15, minimum level to 2, and name to "Willow Staff".
     */
    public WillowStaff() {
        super(15, 2, "Willow Staff");
    };

    @Override
    public WeaponCategory getCategory() {
        return WeaponCategory.STAFF;
    }
}