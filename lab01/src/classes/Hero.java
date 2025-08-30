// The class hero should be a subclass of character
package classes;

public abstract class Hero extends Character {

    public Hero(String name, int healthPoints, int strength) {
        super(name, healthPoints, strength);
    }

    private int level = 1;
    private int experience = 0;

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void gainExperience(int exp) {
        this.experience += exp;
    }

    public abstract void useSpecialSkill(Character target);

    @Override
    public void showStatus() {
        System.out.println("The hero " + getName() + " is at level " + level + " with " + getHealthPoints() + " health points, " + getStrength() + " strength, and " + experience + " experience points.");
    }
}