package classes.weapons;

public class super_bow {
    private int damage;
    private int minNivel;

    public super_bow(int damage, int minNivel) {
        this.damage = 20;
        this.minNivel = 2;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinNivel() {
        return minNivel;
    }
}
