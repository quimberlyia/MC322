package classes;

public class Monster extends Character {

    private int experience;
    private Weapon[] loot;

    public Monster(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength);
        this.experience = experience;
        this.loot = loot;
    }

    public void attack(Character target) {
        int damage = -getStrength();
        target.changeHealth(damage);
        System.out.println(getName() + " attacked " + target.getName() + " for " + damage + " damage.");
    }

    public int getExperience() {
        return experience;
    }

    public Weapon[] getLoot() {
        return loot;
    }

    public void setLoot(Weapon[] loot) {
        this.loot = loot;
    }

    public Weapon dropLoot() {
        int index = (int) (Math.random() * loot.length);
        return loot[index];
    }

    @Override
    public void showStatus() {
        // Pretty print for Monster status
        System.out.println("The monster " + getName() + " has " + getHealthPoints() + " health points, " + getStrength() + " strength, and is worth " + experience + " experience points.");
    }
}
