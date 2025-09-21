package com.rpglab.game.enums;

public enum Difficulty {
    EASY(0.8, 0.8), // Multipliers for easy difficulty
    MEDIUM(1.0, 1.0),
    HARD(1.3, 1.2);

    private final double lifeMult; // Life multiplier
    private final double damageMult; // Damage multiplier

    Difficulty(double lifeMult, double damageMult) {
        this.lifeMult = lifeMult; // Initialize life multiplier
        this.damageMult = damageMult;  // Initialize damage multiplier
    }

    public double getLifeMult() {
        return lifeMult;
    }

    public double getDamageMult() {
        return damageMult;
    }
}
