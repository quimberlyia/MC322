package classes.heroes;

import classes.Character;
import classes.Hero;

public class Archer extends Hero {
    private int aim;

    public Archer(String name, int healthPoints, int strength, int aim) {
        super(name, healthPoints, strength);
        this.aim = aim;
    }

    public int getAim() {
        return aim;
    }

    public void useSpecialSkill(Character target) {
        if (aim >= 5) {
            int damage = getStrength() * 2;
            target.changeHealth(damage);
            System.out.println(getName() + " used a precise shot on " + target.getName() + " for " + damage + " damage!");
            aim -= 5;
        } else {
            System.out.println(getName() + " does not have enough aim to use the special skill!");
        }
    }

    public void attack(Character target) {
        int damage = getStrength();
        target.changeHealth(damage);
        System.out.println(getName() + " shot " + target.getName() + " and deal " + damage + " damage.");
    }
}
