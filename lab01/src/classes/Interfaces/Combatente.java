package classes.Interfaces;

public interface Combatente {
    String getNome();
    boolean isAlive();
    int getHealthPoints();
    void getDamage(int dano);
    void getCure(int cura);
    CombactAction escolherAcao(Combatente alvo);
}
