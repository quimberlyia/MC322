package classes;

public abstract class Weapon {
    private int damage;
    private int minNivel;
    private String name;

    public Weapon(int damage, int minNivel, String name) {
        this.damage = damage;
        this.minNivel = minNivel;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinNivel() {
        return minNivel;
    }

    public String getName() {
        return name;
    }
}

