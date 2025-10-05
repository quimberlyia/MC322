package com.rpglab.game.items.weapons;

import com.rpglab.game.items.Weapon;

/**
 * An upgraded bow weapon for Archer heroes.
 * The Super Bow provides enhanced damage output compared to the basic Bow,
 * making it a mid-tier weapon suitable for characters who have gained
 * some experience in combat.
 * 
 * <p>This weapon requires level 2 to equip and deals 20 damage,
 * representing a significant upgrade over the basic bow.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class SuperBow extends Weapon {
    /**
     * Constructs a new Super Bow with enhanced attributes.
     * Sets damage to 20, minimum level to 2, and name to "Super Bow".
     */
    public SuperBow() {
        super(20, 2, "Super Bow");
    };

    @Override
    public WeaponCategory getCategory() {
        return WeaponCategory.BOW;
    }
}