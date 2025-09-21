package com.rpglab.game.interfaces;

/**
 * Represents any item that can exist within the Dungeon Adventure RPG world.
 * This interface provides the basic contract for all items including weapons,
 * consumables, equipment, and other game objects that players can interact with.
 * 
 * <p>All items must have an identifiable name that can be displayed to players
 * for inventory management, combat descriptions, and game interactions.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public interface Item {
    
    /**
     * Returns the name of this item.
     * The name should be descriptive and suitable for display to players.
     * 
     * @return The name of the item as a String
     */
    public String getName();
}
