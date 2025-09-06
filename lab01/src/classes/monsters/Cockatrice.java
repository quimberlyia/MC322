package classes.monsters;

import classes.Monster;

public class Cockatrice extends Monster {

    public Cockatrice(String name, int healthPoints, int strength, int experience) {
        super(name, healthPoints, strength, experience);
    }

    public void attack(classes.Character target) {
        int damage = -getStrength();
        target.changeHealth(damage);

        String[] attacks = {
            " petrifying gaze",
            " tail swipe"
        };

        int randomIndex = (int) (Math.random() * attacks.length);
        String attack = attacks[randomIndex];
        System.out.println(getName() + " used " + attack + " on " + target.getName() + " and deal " + damage + " damage.");
    }
}
