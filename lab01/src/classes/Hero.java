// The class hero should be a subclass of character
package classes;

import java.util.List;
import java.util.ArrayList;

import interfaces.CombatAction;
import interfaces.Combatente;

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
        System.out.println(getName() + " leveled up to level " + level + "!");
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        if (this.experience >= 100) {
            levelUp();
            this.experience = 0;
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
        System.out.println("The hero " + getName() + " is at level " + level + " with " + getHealthPoints() + " health points, " + getStrength() + " strength, and " + experience + " experience points.");
    }

    public void equipWeapon(Weapon weapon) {

        if (weapon.getMinNivel() > this.level) {
            System.out.println(getName() + " cannot equip " + weapon.getName() + " because they are not at the required level.");
            return;
        }

        setWeapon(weapon);
        System.out.println(getName() + " equipped " + weapon.getName() + "!");
    }
}