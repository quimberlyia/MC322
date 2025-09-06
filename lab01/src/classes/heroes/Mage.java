package classes.heroes;

import classes.Character;
import classes.Hero;

public class Mage extends Hero {
    private int mana;

    public Mage(String name, int healthPoints, int strength, int mana, double lucky) {
        super(name, healthPoints, strength, lucky);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void useSpecialSkill(Character target) {

        // Check if random number is lower than lucky then use spell, otherwise fails

        if (Math.random() > getLucky()) {
            System.out.println(getName() + " tried to use a special skill but failed due to bad luck!");
            return;
        }

        int damage = getStrength() * 3;
        target.changeHealth(damage);
        setMana(getMana() - 10);
        System.out.println(getName() + " used a powerful spell on " + target.getName() + " for " + damage + " damage! Mana left: " + getMana());
    }

    public void attack(Character target) {
        int damage = -getStrength();
        target.changeHealth(damage);
        System.out.println(getName() + " cast a spell on " + target.getName() + " and deal " + damage + " damage.");
    }
}
