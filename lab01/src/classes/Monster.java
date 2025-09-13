package classes;

import java.util.List;

import classes.interfaces.CombactAction;
import classes.interfaces.Combatente;
import classes.interfaces.Item;
import classes.interfaces.Lootable;

import java.util.ArrayList;


public class Monster extends Character implements Lootable  {

    private int experience;
    private Weapon[] loot;
    protected List<CombactAction> actions = new ArrayList<>();

    @Override
    public void getCure(int amount) {
        return ;
    }

    @Override
    public String getNome() {
        return getName();
    }

    @Override
    public CombactAction pickAction(Combatente target) {
        return pickAction(target);
    }

    @Override
    public CombactAction pickAction() {
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

    public List<CombactAction> getActions() {
        return actions;
    }

    public void addAction(CombactAction action) {
        actions.add(action);
    }

    @Override
    public void showStatus() {
        System.out.println("The monster " + getName() + " has " + getHealthPoints() + " health points, " + getStrength() + " strength, and is worth " + experience + " experience points.");
    }
}
