package com.rpglab.game.enums;

/**
 * Represents the different difficulty levels available in the Dungeon Adventure RPG.
 * Each difficulty level has different multipliers that affect combat and character stats.
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public enum Difficulty {
    /** Easy difficulty with reduced life and damage multipliers (80% of normal values) */
    EASY(0.8, 0.8),
    
    /** Medium difficulty with standard multipliers (100% of normal values) */
    MEDIUM(1.0, 1.0),
    
    /** Hard difficulty with increased life and damage multipliers (130% life, 120% damage) */
    HARD(1.3, 1.2);

    /** The multiplier applied to character life points based on difficulty */
    private final double lifeMult;
    
    /** The multiplier applied to damage values based on difficulty */
    private final double damageMult;

    /**
     * Constructs a Difficulty enum with specified multipliers.
     * 
     * @param lifeMult The life multiplier for this difficulty level
     * @param damageMult The damage multiplier for this difficulty level
     */
    Difficulty(double lifeMult, double damageMult) {
        this.lifeMult = lifeMult;
        this.damageMult = damageMult;
    }

    /**
     * Returns the life multiplier for this difficulty level.
     * This multiplier is applied to character health points.
     * 
     * @return The life multiplier as a double value
     */
    public double getLifeMult() {
        return lifeMult;
    }

    /**
     * Returns the damage multiplier for this difficulty level.
     * This multiplier is applied to all damage calculations.
     * 
     * @return The damage multiplier as a double value
     */
    public double getDamageMult() {
        return damageMult;
    }
}
