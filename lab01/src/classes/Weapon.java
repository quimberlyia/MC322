package classes;

public abstract class Weapon {
    private int damage;
    private int minNivel;

    public Weapon(int damage, int minNivel) {
        this.damage = damage;
        this.minNivel = minNivel;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinNivel() {
        return minNivel;
    }

}

