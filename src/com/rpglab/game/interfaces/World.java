package com.rpglab.game.interfaces;

/**
 * Represents a game world that can generate and manage scenes.
 * This interface defines the contract for world generation systems
 * that create the structure and content of the Dungeon Adventure RPG environment.
 * 
 * <p>Worlds are responsible for creating interconnected scenes that
 * form the playable areas of the game, managing their relationships,
 * and providing the overall structure for the hero's adventure.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public interface World {
    
    /**
     * Generates the specified number of scenes for this world.
     * This method creates and initializes scenes that will form
     * the playable content of the game world.
     * 
     * <p>The generated scenes may include various types such as
     * combat encounters, story locations, and environmental hazards,
     * arranged to provide a coherent gameplay experience.</p>
     * 
     * @param scenes_number The number of scenes to generate for this world
     */
    public void generateScenes(int scenes_number);
}
