package com.rpglab.game.items.weapons;

import com.rpglab.game.items.Weapon;

public class Sword extends Weapon {
    public Sword() {
        super(15, 2, "Sword");
    };

    @Override
    public WeaponCategory getCategory() {
        return WeaponCategory.SWORD;
    }
}