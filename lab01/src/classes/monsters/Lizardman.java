package classes.monsters;

import classes.Monster;
import classes.Weapon;

public class Lizardman extends Monster {

    public Lizardman(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
    }

    public void attack(classes.Character target) {
        int damage = -getStrength();
        target.changeHealth(damage);

        String[] attacks = {
            " used poisonmous bite",
            " used claw swipe",
            " used tail whip"
        };

        int randomIndex = (int) (Math.random() * attacks.length);
        String attack = attacks[randomIndex];
        System.out.println(getName() + attack + " on " + target.getName() + " and deal " + damage + " damage.");
    }
}
