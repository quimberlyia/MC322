package com.rpglab.dungeonadventure.items;
import com.rpglab.dungeonadventure.interfaces.Item;

public abstract class Weapon implements Item {
    private int damage;
    private int minNivel;
    private String name;

    public Weapon(int damage, int minNivel, String name) {
        this.damage = damage;
        this.minNivel = minNivel;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinLevel() {
        return minNivel;
    }

    public String getName() {
        return name;
    }
}

