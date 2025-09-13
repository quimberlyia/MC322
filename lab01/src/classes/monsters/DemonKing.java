package classes.monsters;

import classes.Monster;
import classes.Weapon;
import classes.actions.DarkSlash;
import classes.actions.DarkSpell;

public class DemonKing extends Monster {

    public DemonKing(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new DarkSlash());
        addAction(new DarkSpell());
    }
}
