package classes.weapons;

public class moon_staff {
    private int damage;
    private int minNivel;

    public moon_staff(int damage, int minNivel) {
        this.damage = 20;
        this.minNivel = 3;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinNivel() {
        return minNivel;
    }
}
