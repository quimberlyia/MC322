package com.rpglab.game.items.weapons;

import com.rpglab.game.items.Weapon;

/**
 * A versatile sword weapon in the Dungeon Adventure RPG.
 * The Sword is a mid-tier melee weapon that provides balanced damage output.
 * Unlike bows and staves which are class-specific, swords have more flexible
 * usage depending on the game's weapon restriction system.
 * 
 * <p>This weapon requires level 2 to equip and deals 15 damage,
 * providing a reliable option for melee combat.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Sword extends Weapon {
    /**
     * Constructs a new Sword with standard attributes.
     * Sets damage to 15, minimum level to 2, and name to "Sword".
     */
    public Sword() {
        super(15, 2, "Sword");
    };

    @Override
    public WeaponCategory getCategory() {
        return WeaponCategory.SWORD;
    }
}