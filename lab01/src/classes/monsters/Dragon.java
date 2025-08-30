package classes.monsters;

import classes.Monster;

public class Dragon extends Monster {

    public Dragon(String name, int healthPoints, int strength, int experience) {
        super(name, healthPoints, strength, experience);
    }

    public void attack(classes.Character target) {
        int damage = getStrength();
        target.changeHealth(damage);

        String[] attacks = {
            " used roar",
            " used fireball",
            " breathed fire"
        };

        int randomIndex = (int) (Math.random() * attacks.length);
        String attack = attacks[randomIndex];
        System.out.println(getName() + attack + " on " + target.getName() + " and deal " + damage + " damage.");

    }
}
