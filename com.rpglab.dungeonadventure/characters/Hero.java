// The class hero should be a subclass of character
package com.rpglab.dungeonadventure.characters;

import java.util.List;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;
import com.rpglab.dungeonadventure.items.Weapon;
import com.rpglab.dungeonadventure.utils.GameDisplay;

import java.util.ArrayList;

public abstract class Hero extends Character {

    private int level = 1;
    private int experience = 0;
    private double lucky = 0;

    protected List<CombatAction> action = new ArrayList<>();

    @Override
    public abstract CombatAction chooseAction(Combatente target);

    public Hero(String name, int healthPoints, int strength, double lucky) {
        super(name, healthPoints, strength);
        this.lucky = lucky;
    }

    public double getLucky() {
        return lucky;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void setLucky(double lucky) {
        this.lucky = lucky;
    }

    private void levelUp() {
        this.level++;
        this.lucky += 0.1;
        addStrength(level * 3);
        heal(level * 5);

        System.out.println();
        System.out.println(GameDisplay.YELLOW + GameDisplay.BOLD + "LEVEL UP!" + GameDisplay.RESET);
        System.out.println(GameDisplay.YELLOW + getName() + " has reached level " + level + "!" + GameDisplay.RESET);
        System.out.println();
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        while (this.experience >= 100)
        {
            levelUp();
            this.experience -= 100;
        }
    }

    public abstract void useSpecialSkill(Character target);

    public void addAction(CombatAction combatAction) {
        action.add(combatAction);
    }

    public List<CombatAction> getActions() {
        return action;
    }

    @Override
    public void showStatus() {
        String healthBar = "[" + getHealthPoints() + " HP]";
        String strengthBar = "[" + getStrength() + " Strength Points]";
        System.out.println("  " + GameDisplay.BOLD + GameDisplay.BLUE + getName() + GameDisplay.RESET + " Lv." + level);
        System.out.println("    " + healthBar + 
                          " | " + GameDisplay.YELLOW + strengthBar + GameDisplay.RESET +
                          " | " + GameDisplay.PURPLE + "EXP: " + experience + "/100" + GameDisplay.RESET);
        if (getWeapon() != null) {
            System.out.println("    " + GameDisplay.CYAN + getWeapon().getName() + 
                              " (+" + getWeapon().getDamage() + " DMG)" + GameDisplay.RESET);
        }
        System.out.println();
    }

    public void equipWeapon(Weapon weapon) {

        if (weapon.getMinLevel() > this.level) {
            System.out.println(GameDisplay.YELLOW + getName() + " cannot equip " + weapon.getName() + " (requires level " + weapon.getMinLevel() + ")" + GameDisplay.RESET);
            return;
        }

        setWeapon(weapon);
        System.out.println(GameDisplay.CYAN + getName() + " equipped " + weapon.getName() + "!" + GameDisplay.RESET);
    }
}