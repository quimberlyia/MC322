package classes.weapons;

public class extreme_super_bow {
    private int damage;
    private int minNivel;

    public extreme_super_bow(int damage, int minNivel) {
        this.damage = 30;
        this.minNivel = 3;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinNivel() {
        return minNivel;
    }
}
