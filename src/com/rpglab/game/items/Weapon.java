package com.rpglab.game.items;
import com.rpglab.game.interfaces.Item;

public abstract class Weapon implements Item {
    private int damage;
    private int minLevel;
    private String name;

    public Weapon(int damage, int minLevel, String name) {
        this.damage = damage;
        this.minLevel = minLevel;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public String getName() {
        return name;
    }
}

