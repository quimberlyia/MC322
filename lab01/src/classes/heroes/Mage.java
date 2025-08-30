package classes.heroes;

import classes.Character;
import classes.Hero;

public class Mage extends Hero {
    private int mana;

    public Mage(String name, int healthPoints, int strength, int mana) {
        super(name, healthPoints, strength);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void useSpecialSkill(Character target) {
        if (mana >= 10) {
            int damage = getStrength() * 3;
            target.changeHealth(damage);
            mana -= 10;
            System.out.println(getName() + " used a powerful spell on " + target.getName() + " for " + damage + " damage! Mana left: " + mana);
        } else {
            System.out.println(getName() + " does not have enough mana to use the special skill!");
        }
    }

    public void attack(Character target) {
        int damage = getStrength();
        target.changeHealth(damage);
        System.out.println(getName() + " cast a spell on " + target.getName() + " and deal " + damage + " damage.");
    }
}
