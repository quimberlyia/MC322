package classes;

import java.util.List;

import interfaces.CombatAction;
import interfaces.Combatente;
import interfaces.Item;
import interfaces.Lootable;

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
    public String getName() {
        return getName();
    }

    @Override
    public CombatAction chooseAction(Combatente target) {
        return chooseAction(target);
    }

    @Override
    public CombatAction chooseAction() {
        if (actions.isEmpty()) return null;
        return actions.get(0);
    }

    public Monster(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength);
        this.experience = experience;
        this.loot = loot;
    }

    public void attack(Character target) {
        int damage = -getStrength();
        target.changeHealth(damage);
        System.out.println(getName() + " attacked " + target.getName() + " for " + damage + " damage.");
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
        System.out.println("The monster " + getName() + " has " + getHealthPoints() + " health points, " + getStrength() + " strength, and is worth " + experience + " experience points.");
    }
}
