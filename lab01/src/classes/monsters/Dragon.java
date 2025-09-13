package classes.monsters;

import classes.Monster;
import classes.Weapon;
import classes.actions.Roar;
import classes.actions.FireBreath;

public class Dragon extends Monster {

    public Dragon(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new Roar());
        addAction(new FireBreath());
    }
}
