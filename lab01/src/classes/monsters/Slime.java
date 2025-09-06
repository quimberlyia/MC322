package classes.monsters;

import classes.Monster;
import classes.Weapon;

public class Slime extends Monster {

    public Slime(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
    }

    public void attack(classes.Character target) {
        int damage = -getStrength();
        target.changeHealth(damage);

        String[] attacks = {
            " swallows",
            " used acid spit"
        };

        int randomIndex = (int) (Math.random() * attacks.length);
        String attack = attacks[randomIndex];
        System.out.println(getName() + attack + " on " + target.getName() + " and deal " + damage + " damage.");
    }
}
