package com.rpglab.game.interfaces;

import com.rpglab.game.characters.Hero;
import com.rpglab.game.enums.SceneType;

/**
 * Represents a scene or location within the Dungeon Adventure RPG world.
 * Scenes are discrete areas that heroes can visit, each with specific
 * characteristics, events, and completion conditions.
 * 
 * <p>Scenes may contain combat encounters, story events, environmental
 * hazards, or other interactive elements that affect the hero's journey
 * through the game world.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public interface Scene {
    
    /**
     * Initiates this scene with the specified hero.
     * This method begins the scene's events, interactions, and effects
     * that the hero will experience.
     * 
     * @param hero The hero entering or starting this scene
     */
    public void Start(Hero hero);
    
    /**
     * Checks whether this scene has been completed.
     * Completion conditions vary by scene type and may include defeating
     * enemies, solving puzzles, or reaching specific objectives.
     * 
     * @return true if the scene is completed, false otherwise
     */
    public boolean isCompleted();
    
    /**
     * Returns the type of this scene.
     * The scene type determines the specific characteristics, effects,
     * and behaviors associated with this scene.
     * 
     * @return The SceneType enum value representing this scene's type
     */
    public SceneType getSceneType();
}