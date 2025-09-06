package classes;

public class Monster extends Character {

    private int experience;

    public Monster(String name, int healthPoints, int strength, int experience) {
        super(name, healthPoints, strength);
        this.experience = experience;
    }

    public void attack(Character target) {
        int damage = -getStrength();
        target.changeHealth(damage);
        System.out.println(getName() + " attacked " + target.getName() + " for " + damage + " damage.");
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public void showStatus() {
        // Pretty print for Monster status
        System.out.println("The monster " + getName() + " has " + getHealthPoints() + " health points, " + getStrength() + " strength, and is worth " + experience + " experience points.");
    }
}
