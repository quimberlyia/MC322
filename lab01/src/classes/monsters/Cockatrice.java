package classes.monsters;

import classes.Monster;
import classes.Weapon;
import classes.interfaces.CombactAction;

import classes.Character;

public class Cockatrice extends Monster {

    public Cockatrice(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        actions.add(new CombactAction("Petrifying Gaze", "Petrifies the target"));
        actions.add(new CombactAction("Tail Swipe", "Hits the target with its tail"));
    }


    @Override
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
