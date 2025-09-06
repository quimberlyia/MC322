package classes.weapons;

public class willow_staff {
    private int damage;
    private int minNivel;

    public willow_staff(int damage, int minNivel) {
        this.damage = 15;
        this.minNivel = 2;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinNivel() {
        return minNivel;
    }
}
