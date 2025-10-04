package com.rpglab.game.Exceptions;

/**
 * Exception thrown when a character attempts an action but lacks sufficient resources.
 * This exception is used to indicate that an operation cannot be completed due to
 * insufficient resources such as mana, stamina, health, or other consumable attributes.
 * 
 * <p>Common scenarios that trigger this exception include:</p>
 * <ul>
 *   <li>Attempting to cast a spell without enough mana</li>
 *   <li>Trying to use a special ability with insufficient stamina</li>
 *   <li>Using a healing item when inventory is empty</li>
 *   <li>Performing actions that require minimum health thresholds</li>
 * </ul>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class NotEnoughResourceException extends RuntimeException {

    /**
     * Constructs a new NotEnoughResourceException with the specified detail message.
     * The message should describe the specific resource shortage and the action
     * that failed, providing clear feedback about what resources are needed.
     * 
     * @param message The detail message explaining the resource shortage
     */
    public NotEnoughResourceException(String message) {
        super(message);
    }
}
