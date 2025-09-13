package classes.monsters;

import classes.Monster;
import classes.Weapon;
import classes.actions.RustySword;
import classes.actions.Tackle;

public class Skeleton extends Monster {

    public Skeleton(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new RustySword());
        addAction(new Tackle());
    }
}
