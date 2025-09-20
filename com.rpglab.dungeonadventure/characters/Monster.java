package com.rpglab.dungeonadventure.characters;

import java.util.List;
import java.util.Random;

import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;
import com.rpglab.dungeonadventure.interfaces.Item;
import com.rpglab.dungeonadventure.interfaces.Lootable;
import com.rpglab.dungeonadventure.items.Weapon;
import com.rpglab.dungeonadventure.utils.GameDisplay;

import java.util.ArrayList;


public class Monster extends Character implements Lootable  {

    private int experience;
    private Weapon[] loot;
    protected List<CombatAction> actions = new ArrayList<>();

    @Override
    public void heal(int amount) {
        return ;
    }

    @Override
    public CombatAction chooseAction(Combatente target) {
        if (actions.isEmpty()) return null;
        Random rand = new Random();
        int idx = rand.nextInt(actions.size());
        return actions.get(idx);
    }

    public Monster(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength);
        this.experience = experience;
        this.loot = loot;
    }

    public int getExperience() {
        return experience;
    }

    public Weapon[] getLoot() {
        return loot;
    }

    public void setLoot(Weapon[] loot) {
        this.loot = loot;
    }

    @Override
    public Item dropLoot() {
        int index = (int) (Math.random() * loot.length);
        return (Item) loot[index];
    }

    public List<CombatAction> getActions() {
        return actions;
    }

    public void addAction(CombatAction action) {
        actions.add(action);
    }

    @Override
    public void showStatus() {
        String healthBar = "[" + getHealthPoints() + " HP]";
        String strengthBar = "[" + getStrength() + " Strength Points]";
        System.out.println("  " + GameDisplay.BOLD + GameDisplay.RED + getName() + GameDisplay.RESET);
        System.out.println("    " + healthBar + 
                          " | " + GameDisplay.YELLOW + strengthBar + GameDisplay.RESET +
                          " | " + GameDisplay.PURPLE + "Worth: " + experience + " EXP" + GameDisplay.RESET);
        System.out.println();
    }
}
