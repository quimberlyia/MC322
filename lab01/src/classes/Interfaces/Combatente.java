package classes.interfaces;


public interface Combatente {
    String getNome();
    boolean isAlive();
    int getHealthPoints();
    void takeDamage(int damage);
    void getCure(int cure);
    CombactAction pickAction(Combatente target);
}
