package classes;

public abstract class Character {

    private String name;
    private int healthPoints;
    private int strength;

    public Character(String name, int healthPoints, int strength) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void changeHealth(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    public abstract void attack(Character target);

    public void showStatus() {
        System.out.println("Player: " + name + ", Health Points: " + healthPoints + ", Strength: " + strength);
    }
}