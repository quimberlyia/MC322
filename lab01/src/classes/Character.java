package classes;

import interfaces.CombatAction;
import interfaces.Combatente;

public abstract class Character implements Combatente {

    private String name;
    private int healthPoints;
    private int strength;
    private Weapon weapon;    

    public Character(String name, int healthPoints, int strength) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public void addStrength(int increment) {
        this.strength += increment;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    private void changeHealth(int damage) {
        this.healthPoints += damage;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // Implementação dos métodos da interface Combatente
    @Override
    public void takeDamage(int damage) {
        changeHealth(-damage);
    }

    @Override
    public void heal(int amount) {
        changeHealth(amount);
    }

    @Override
    public boolean isAlive() {
        return healthPoints > 0;
    }

    public abstract CombatAction chooseAction(Combatente target);

    public void showStatus() {
        System.out.println("Player: " + name + ", Health Points: " + healthPoints + ", Strength: " + strength);
    }
}

