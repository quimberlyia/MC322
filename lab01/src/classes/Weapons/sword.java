package classes.weapons;

public class sword {
    private int damage;
    private int minNivel;

    public sword(int damage, int minNivel) {
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
