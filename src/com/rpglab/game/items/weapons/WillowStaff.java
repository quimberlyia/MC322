package com.rpglab.game.items.weapons;

import com.rpglab.game.items.Weapon;

public class WillowStaff extends Weapon {
    public WillowStaff() {
        super(15, 2, "Willow Staff");
    };

    @Override
    public WeaponCategory getCategory() {
        return WeaponCategory.STAFF;
    }
}