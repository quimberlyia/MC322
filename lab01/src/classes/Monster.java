package classes;

import java.util.List;
import java.util.Random;

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
        System.out.println("The monster " + getName() + " has " + getHealthPoints() + " health points, " + getStrength() + " strength, and is worth " + experience + " experience points.");
    }
}
