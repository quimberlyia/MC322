package com.rpglab.game.interfaces;

public interface Combatente {
    String getName();
    boolean isAlive();
    int getHealthPoints();
    void takeDamage(int damage);
    void heal(int amount);
    CombatAction chooseAction(Combatente target);
    int getStrength();
}
