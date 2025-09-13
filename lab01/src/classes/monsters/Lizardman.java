package classes.monsters;

import classes.Monster;
import classes.Weapon;
import classes.actions.PoisonousBite;
import classes.actions.ClawSwipe;
import classes.actions.TailWhip;

public class Lizardman extends Monster {

    public Lizardman(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new PoisonousBite());
        addAction(new ClawSwipe());
        addAction(new TailWhip());
    }
}
