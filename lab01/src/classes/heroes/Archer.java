package classes.heroes;

import classes.Character;
import classes.Hero;

import classes.Weapons.Bow;

public class Archer extends Hero {
    private int aim;

    public Archer(String name, int healthPoints, int strength, int aim, double lucky) {
        super(name, healthPoints, strength, lucky);
        this.aim = aim;
        setWeapon(new Bow());
    }

    public int getAim() {
        return aim;
    }

    public void useSpecialSkill(Character target) {

        if (Math.random() > getLucky()) {
            System.out.println(getName() + " tried to use a special skill but failed due to bad luck!");
            return;
        }

        int damage = getStrength() * 2;
        target.changeHealth(damage);
        System.out.println(getName() + " used a precise shot on " + target.getName() + " for " + damage + " damage!");
    }

    public void attack(Character target) {
        int damage = -getStrength() * getWeapon().getDamage();
        target.changeHealth(damage);
        System.out.println(getName() + " shot " + target.getName() + " and deal " + damage + " damage.");
    }
}
