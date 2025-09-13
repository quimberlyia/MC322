package interfaces;

public interface Combatente {
    String getNome();
    boolean isAlive();
    int getHealthPoints();
    void getDamage(int dano);
    void getCure(int cura);
    CombatAction escolherAcao(Combatente alvo);
}
