package classes.monsters;

import classes.Monster;
import classes.Weapon;
import classes.actions.PetrifyingGaze;
import classes.actions.TailSwipe;

public class Cockatrice extends Monster {

    public Cockatrice(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new PetrifyingGaze());
        addAction(new TailSwipe());
    }
}
