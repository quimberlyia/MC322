package classes.weapons;

public class staff {
    private int damage;
    private int minNivel;

    public staff(int damage, int minNivel) {
        this.damage = 10;
        this.minNivel = 1;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinNivel() {
        return minNivel;
    }
}
