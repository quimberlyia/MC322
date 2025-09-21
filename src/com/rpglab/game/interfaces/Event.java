package com.rpglab.game.interfaces;

/**
 * Represents a game event that can be triggered and executed based on specific conditions.
 * Events provide dynamic gameplay elements that respond to game state changes,
 * player actions, or other triggering mechanisms.
 * 
 * <p>Events can include story sequences, environmental changes, combat encounters,
 * item rewards, or any other game mechanics that need conditional execution.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public interface Event {
    
    /**
     * Checks whether the conditions for triggering this event are met.
     * This method evaluates the current game state to determine if
     * the event should be activated.
     * 
     * <p>Trigger conditions may include player actions, game progress,
     * character states, or other contextual factors specific to the event.</p>
     */
    public void checkTrigger();
    
    /**
     * Executes this event's effects and actions.
     * This method is called when the event has been triggered and
     * should perform all necessary operations associated with the event.
     * 
     * <p>Event execution may involve displaying messages, modifying game state,
     * spawning enemies, granting rewards, or other gameplay effects.</p>
     */
    public void run();
}