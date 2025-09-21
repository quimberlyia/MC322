package com.rpglab.game.interfaces;

/**
 * Represents entities that can drop loot when defeated or interacted with.
 * This interface is typically implemented by monsters and other game entities
 * that provide rewards to players upon certain conditions being met.
 * 
 * <p>Lootable entities can drop various types of items including weapons,
 * consumables, equipment, or other valuable game objects that enhance
 * the player's capabilities or progress.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public interface Lootable {
    
    /**
     * Generates and returns loot dropped by this entity.
     * The type and quality of loot may vary based on the entity's characteristics,
     * difficulty level, or random factors.
     * 
     * @return An Item representing the dropped loot, or null if no loot is dropped
     */
    public Item dropLoot();
}
