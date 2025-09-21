package enums;

public enum Dificult {
    EASY(0.8, 0.8), // Multiplicadores para dificuldade fácil
    MEDIUM(1.0, 1.0),
    HARD(1.3, 1.2);

    private final double lifeMult; // Multiplicador de vida
    private final double damageMult; // Multiplicador de dano

    Dificult(double lifeMult, double damageMult) {
        this.lifeMult = lifeMult; // Inicializa o multiplicador de vida
        this.damageMult = damageMult;  // Inicializa o multiplicador de dano
    }

    public double getLifeMult() {
        return lifeMult;
    }

    public double getDamageMult() {
        return damageMult;
    }
}
