package classes.monsters;

import classes.Monster;
import classes.Weapon;
import classes.actions.AcidSpit;
import classes.actions.Swallow;

public class Slime extends Monster {

    public Slime(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new AcidSpit());
        addAction(new Swallow());
    }
}
